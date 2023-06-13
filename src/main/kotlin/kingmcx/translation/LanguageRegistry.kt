package kingmcx.translation

import kingmc.common.context.annotation.Service
import kingmc.platform.entity.player.Player
import java.util.UUID

/**
 * A registry stores language for players
 *
 * @since 0.0.9
 * @author kingsthere
 */
@Service
interface LanguageRegistry {
    /**
     * Gets the language for player
     *
     * @param player the player to get language for
     * @return the language
     */
    fun getByPlayer(player: Player): Language

    /**
     * Gets the language by uuid
     *
     * @param uuid the uuid of player to get language for
     * @return the language
     */
    fun getByUUID(uuid: UUID): Language
}