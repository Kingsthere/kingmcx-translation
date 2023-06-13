package kingmcx.translation

import kingmc.common.application.WithApplication
import kingmc.common.application.currentApplication
import kingmc.common.context.annotation.Service
import kingmc.platform.audience.Audience

/**
 * A superinterface declare the api to access the languages of audiences such as:
 *  + players
 *  + web users
 *
 * @since 0.0.9
 * @author kingsthere
 */
@Service
interface LanguageService {
    /**
     * Convert an [audience] as a [TranslatedAudience]
     *
     * @param audience the audience to get from
     * @since 0.0.9
     */
    fun getTranslatedAudience(audience: Audience): TranslatedAudience
}

/**
 * The language service of current application
 */
@get:WithApplication
val languageService: LanguageService
    get() = currentApplication().context.getBean(LanguageService::class)

/**
 * Get a player with language from
 * current language object provider
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun Audience.toTranslatedAudience(): TranslatedAudience =
    currentApplication().context.getBean(LanguageService::class)
        .getTranslatedAudience(this)

/**
 * The language of a player
 */
val Audience.language: Language
    get() = currentApplication().context.getBean(LanguageService::class)
        .getTranslatedAudience(this)
        .language
