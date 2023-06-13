package kingmcx.translation.impl

import com.github.benmanes.caffeine.cache.Caffeine
import com.github.benmanes.caffeine.cache.LoadingCache
import kingmc.common.application.withApplication
import kingmc.common.context.annotation.Autowired
import kingmc.common.context.annotation.Component
import kingmc.modules.persistence.defaultDatabase
import kingmc.platform.entity.player.Player
import kingmc.util.Reloadable
import kingmcx.translation.Language
import kingmcx.translation.LanguageFactory
import kingmcx.translation.LanguageRegistry
import kingmcx.translation.impl.sql.LanguageTable
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

/**
 * A simple `LanguageRegistry` implementation
 *
 * @since 0.0.9
 * @author kingsthere
 */
@Component
object LanguageRegistryImpl : LanguageRegistry, Reloadable {
    @Autowired
    lateinit var languageTable: LanguageTable

    @Autowired
    lateinit var languageFactory: LanguageFactory

    private var database = withApplication { defaultDatabase }

    private val _cache: LoadingCache<UUID, Language> = Caffeine.newBuilder()
        .build {
            transaction(database) {
                val languageKey = languageTable.select { LanguageTable.id eq it.toString() }.single()[LanguageTable.language]
                languageFactory.named(languageKey)
            }
        }

    override fun reload() {
        database = defaultDatabase
    }

    override fun getByPlayer(player: Player): Language {
        return getByUUID(player.uuid)
    }

    override fun getByUUID(uuid: UUID): Language {
        return _cache.get(uuid)!!
    }
}