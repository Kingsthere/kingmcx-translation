package kingmcx.translation

import kingmc.util.key.Key
import kingmcx.translation.Translation
import kingmcx.translation.TranslationContainer

/**
 * The abstract implement for [TranslationContainer]
 *
 * @since 0.0.9
 * @author kingsthere
 */
abstract class AbstractTranslationContainer : TranslationContainer {
    private val value: MutableMap<Key, Translation> = HashMap()

    @Throws(TranslationException::class)
    override fun get(key: Key): Translation {
        if (value.containsKey(key)) {
            return value[key]!!
        } else {
            throw TranslationException("Invalid key ${key.asString()}")
        }
    }

    override fun plus(translation: Translation) {
        value[translation.key] = translation
    }

    override fun translations(): Map<Key, Translation> =
        value
}