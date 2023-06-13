package kingmcx.translation

import kingmc.common.application.getProperty
import kingmc.common.logging.info
import kingmc.modules.configuration.access.Configuration
import kingmc.modules.configuration.access.get
import kingmc.modules.configuration.access.getAllSections
import kingmc.modules.configuration.newReader
import kingmc.util.key.toKey
import java.io.File

/**
 * A type of [LanguageFactory] provide language instances
 * by using the configuration files, this load languages
 * when this class instantiate
 *
 * @since 0.0.9
 * @author kingsthere
 */
open class FileLanguageFactory(val languageDirectory: File) : LanguageFactory {
    /**
     * Record the languages that is already
     * registered in this factory
     *
     * @since 0.0.9
     * @author kingsthere
     */
    protected val values: MutableList<Language> = ArrayList()


    init {
        // Traveler each files in directory
        for (file in languageDirectory.listFiles()!!) {
            values.add(languageFromFile(file, newReader(LanguageConfig, file)))
        }
    }

    /**
     * Get/Create a language by using the
     * configuration file of that language, throw
     * [InvalidLanguageException] if the configuration
     * file provides is not valid
     *
     * @since 0.0.9
     * @throws InvalidLanguageException if the configuration file provides
     *                                  is not valid
     * @return the language got
     */
    @Throws(InvalidLanguageException::class)
    fun languageFromFile(name: String): Language {
        val optionalLanguage = values.stream()
            .filter { language -> language.name.equals(name, ignoreCase = true) }
            .findAny()
        if (optionalLanguage.isPresent) {
            return optionalLanguage.get()
        } else {
            throw InvalidLanguageException("Language not found $name")
        }
    }

    override fun named(name: String): Language =
        values.find { it.name == name } ?: throw IllegalArgumentException("Language with name $name not found")

    override fun default(): Language = named(getProperty("translation.language.default"))

    /**
     * Get all languages that is created from
     * this factory and return as a [List]
     *
     * @since 0.0.9
     * @return the languages got
     */
    override fun iterator(): Iterator<Language> {
        return values.iterator()
    }

    private fun languageFromFile(file: File, configuration: Configuration<LanguageConfig>): Language {
        val language: Language
        val languageName = configuration.get { name }!!.ifEmpty { file.name.split(".")[0] }
        val displayName: String = configuration.get { displayName }!!
        val localizedName: String = configuration.get { localizedName }!!
        info("Loading language $languageName($localizedName)")
        language = if (languageName == "general") {
            GeneralLanguage
        } else {
            GenericLanguage(true, languageName, displayName, localizedName)
        }

        for (translationSection in configuration.getAllSections()) {
            for (translation in translationSection.value.valueMap()) {
                val text = translation.value as String
                info("Load translation ${translationSection.key}:${translation.key}")
                val translations = Translation.of("${translationSection.key}:${translation.key}".toKey(), text)
                language.plus(translations)
            }
        }
        return language
    }
}