package kingmcx.translation.impl.sql

import kingmc.modules.persistence.sql.Schema
import org.jetbrains.exposed.sql.Table

/**
 * The table store the languages of each player
 *
 * @since 0.0.9
 * @author kingsthere
 * @see Table
 */
@Schema("languages")
object LanguageTable : Table() {
    /**
     * The uuid of the player
     */
    val id = char("name", 36)

    /**
     * The name(identifier) of the language
     */
    val language = varchar("language", 36)

    override val primaryKey = PrimaryKey(id)
}