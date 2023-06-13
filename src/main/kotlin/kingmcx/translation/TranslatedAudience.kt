package kingmcx.translation

import kingmc.platform.audience.Audience

/**
 * Interface indicates an Audience have a language set
 *
 * @since 0.0.9
 * @author kingsthere
 */
interface TranslatedAudience : Audience {
    /**
     * The language of this audience
     */
    val language: Language
}