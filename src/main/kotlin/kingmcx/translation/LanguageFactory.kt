package kingmcx.translation

import kingmc.util.SubclassSingleton

/**
 * Represent a factory that provides many language
 * instances from configuration files, any other ways
 *
 * @since 0.0.9
 * @author kingsthere
 * @see Language
 */
@SubclassSingleton
interface LanguageFactory : Iterable<Language> {
    /**
     * Get/Create a language from using the configuration file of that language, throw
     * [InvalidLanguageException] if the language name provides is not valid
     *
     * @since 0.0.9
     * @throws InvalidLanguageException if the configuration file provides
     *                                  is not valid
     * @param name the name of the language
     * @return the language got
     */
    @Throws(InvalidLanguageException::class)
    fun named(name: String): Language

    /**
     * Gets the default language to use when a new player joined
     *
     * @return the default language
     */
    fun default(): Language

    /**
     * Get all languages that is created from
     * this factory and return as a [List]
     *
     * @return the languages got
     */
    override fun iterator(): Iterator<Language>
}