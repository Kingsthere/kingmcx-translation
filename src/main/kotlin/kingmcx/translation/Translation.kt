package kingmcx.translation

import kingmc.util.errorprone.Immutable
import kingmc.util.format.Formatted
import kingmc.util.key.Key
import kingmc.util.key.Keyed
import kingmcx.translation.impl.TranslationImpl

/**
 * Represent a strip of translation, a translation is
 * a immutable class stores the key of the translation
 * and the value of translation like a [Map.Entry]. A translation
 * must:
 *  + Only support for one [Language]
 *
 * A [Translation] use the [Key] as the unique
 * identifier to identity every translation in a translation
 * container
 *
 * @since 0.0.9
 * @author kingsthere
 * @see Language
 * @see TranslationContainer
 */
@Immutable
interface Translation : Keyed {
    /**
     * To get the key of this translation, also
     * the unique identifier of a [Translation]
     *
     * @since 0.0.9
     */
    override val key: Key

    /**
     * Return the original value of this translation
     *
     * @since 0.0.9
     * @author kingsthere
     */
    @get:Formatted
    val value: String

    companion object {
        /**
         * Create a translation in easily way
         *
         * @since 0.0.9
         * @author kingsthere
         */
        fun of(key: Key, text: String): Translation = TranslationImpl(key, text)
    }
}