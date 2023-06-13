package kingmcx.translation.impl

import kingmc.platform.audience.Console
import kingmc.platform.entity.player.Player
import kingmcx.translation.Language
import kingmcx.translation.TranslatedAudience

/**
 * A simple [TranslatedAudience] implementation for console
 *
 * @since 0.0.9
 * @author kingsthere
 */
class TranslatedConsoleImpl(private val parent: Console) : TranslatedAudience, Console by parent {
    override val language: Language
        get() = LanguageRegistryImpl.languageFactory.default()
}