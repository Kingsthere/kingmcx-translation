package kingmcx.translation.impl

import kingmc.platform.entity.player.Player
import kingmcx.translation.Language
import kingmcx.translation.TranslatedAudience

/**
 * A simple [TranslatedAudience] implementation for player
 *
 * @since 0.0.9
 * @author kingsthere
 */
class TranslatedPlayerImpl(private val parent: Player) : TranslatedAudience, Player by parent {
    override val language: Language
        get() = LanguageRegistryImpl.getByPlayer(parent)
}