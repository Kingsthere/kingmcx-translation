package kingmcx.translation

import kingmc.modules.configuration.Config
import kingmc.modules.configuration.string
import kingmc.modules.configuration.withDefault

/**
 * A config to configure languages
 *
 * @since 0.0.9
 * @author kingsthere
 */
object LanguageConfig : Config() {
    /**
     * The name of this language, the only identifier of
     * a language, by default it depend on the language config file name,
     * the format of [name] is `ISO 639`, for examples:
     *  + `en_US`
     *  + `zh_CN`
     *
     * @since 0.0.9
     */
    val name = string("name") withDefault ""

    /**
     * The display name, all display names written in **english**
     */
    val displayName = string("displayName")

    /**
     * The localized name, the display name written in **locale** this
     * config represent
     */
    val localizedName = string("localizedName")
}