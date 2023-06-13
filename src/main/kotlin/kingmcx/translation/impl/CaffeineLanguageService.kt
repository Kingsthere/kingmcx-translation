package kingmcx.translation.impl

import com.github.benmanes.caffeine.cache.Caffeine
import com.github.benmanes.caffeine.cache.LoadingCache
import kingmc.common.context.annotation.Service
import kingmc.platform.audience.Audience
import kingmc.platform.audience.Console
import kingmc.platform.entity.player.Player
import kingmcx.translation.LanguageService
import kingmcx.translation.TranslatedAudience

/**
 * An implement of LanguageProvider to provide and cache language players by caffeine
 *
 * @since 0.0.9
 * @author kingsthere
 */
@Service
object CaffeineLanguageService : LanguageService {
    private val _players: LoadingCache<Player, TranslatedAudience> = Caffeine.newBuilder().build { audience ->
        TranslatedPlayerImpl(audience)
    }

    private var _console: TranslatedAudience? = null

    override fun getTranslatedAudience(audience: Audience): TranslatedAudience {
        return when (audience) {
            is Player -> {
                _players.get(audience)!!
            }

            is Console -> {
                if (_console == null) {
                    _console = TranslatedConsoleImpl(audience)
                }
                return _console!!
            }

            else -> {
                throw IllegalArgumentException("Unsupported audience: $audience")
            }
        }
    }
}