package kingmcx.translation

import kingmc.util.key.Key
import kingmcx.translation.TranslationException

/**
 * A translation container represent that an object
 * owns the feature to contains many translation
 *
 * @since 0.0.9
 * @author kingsthere
 */
interface TranslationContainer {
    /**
     * To get a translation in this container
     *
     * @since 0.0.9
     * @throws TranslationException if the translation is
     *                              not exist in this registry
     * @return the translation got in this container
     */
    @Throws(TranslationException::class)
    operator fun get(key: Key): Translation

    /**
     * Add a translation into this translation
     * container, throw [TranslationException] if
     * the translation provides is invalid
     *
     * @since 0.0.9
     * @throws TranslationException if the translation is
     *         already exists in this registry
     * @throws UnsupportedOperationException if this registry
     *         is immutable
     */
    @Throws(UnsupportedOperationException::class, TranslationException::class)
    operator fun plus(translation: Translation)

    /**
     * Return you a [Map] to list all translations
     * that is in this container
     *
     * @since 0.0.9
     */
    fun translations(): Map<Key, Translation>
}