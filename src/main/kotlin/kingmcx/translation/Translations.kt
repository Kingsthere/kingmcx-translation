package kingmcx.translation

import kingmc.common.text.Text
import kingmc.platform.audience.kind.TextCapable
import kingmc.platform.util.format
import kingmc.platform.util.solveText
import kingmc.util.format.Formatted
import kingmc.util.key.Key
import kingmc.util.key.toKey

/**
 * Return the value of this translation that represent
 * as a [Text]
 *
 * @since 0.0.9
 * @see Text
 */
@Formatted
operator fun Translation.invoke(): Text =
    solveText(this.value.format())

/**
 * Return the value of this translation that represent
 * as a [Text] with the specifying formats
 *
 * @since 0.0.9
 * @see Text
 */
@Formatted
operator fun Translation.invoke(vararg formats: Any?): Text =
    solveText(this.value.format(*formats))

/**
 * Get a translation from a translation container
 *
 * @since 0.0.9
 * @author kingsthere
 * @param key the key of the translation to get from
 * @see TranslationContainer
 * @see InvalidLanguageException
 * @see Translation
 * @throws InvalidLanguageException thrown if the translation
 *                                  is not found
 */
@Throws(InvalidLanguageException::class)
fun TranslationContainer.translationOf(key: Key): Translation =
    this[key]

/**
 * Get a translation from a translation container specifying
 *
 * @since 0.0.9
 * @author kingsthere
 * @param key the key of the translation to get from
 * @see TranslationContainer
 * @see InvalidLanguageException
 * @see Translation
 * @throws InvalidLanguageException thrown if the translation
 *                                  is not found
 */
fun translationOf(key: Key, container: TranslationContainer): Translation =
    container.translationOf(key)

/**
 * Get a translation from a translation container the
 * supply from specifying language object
 *
 * @since 0.0.9
 * @author kingsthere
 * @param key the key of the translation to get from
 * @see TranslationContainer
 * @see InvalidLanguageException
 * @see Translation
 * @throws InvalidLanguageException thrown if the translation
 *                                  is not found
 */
fun translationOf(key: Key, obj: TranslatedAudience): Translation =
    obj.language.translationOf(key)

/**
 * Send a [Translation] to the receiver
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TextCapable.sendTranslation(translation: Translation) {
    this.sendText(translation())
}

/**
 * Send a [Translation] to the receiver
 * specifying formats
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TextCapable.sendTranslation(translation: Translation, vararg formats: Any?) {
    this.sendText(translation(*formats))
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TranslatedAudience.sendTranslation(translation: String, language: Language = this.language) {
    this.sendTranslation(language.translationOf(translation.toKey()))
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 * with specifying formats
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TranslatedAudience.sendTranslation(translation: String, language: Language = this.language, vararg formats: Any?) {
    this.sendTranslation(language.translationOf(translation.toKey()), formats)
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TextCapable.sendTranslation(translation: String, language: Language) {
    this.sendTranslation(language.translationOf(translation.toKey()))
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 * with specifying formats
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TextCapable.sendTranslation(translation: String, language: Language, vararg formats: Any?) {
    this.sendTranslation(language.translationOf(translation.toKey()), formats)
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TranslatedAudience.sendTranslation(translation: Key, language: Language = this.language) {
    this.sendTranslation(language.translationOf(translation))
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 * with specifying formats
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TranslatedAudience.sendTranslation(translation: Key, language: Language = this.language, vararg formats: Any?) {
    this.sendTranslation(language.translationOf(translation), formats)
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TextCapable.sendTranslation(translation: Key, language: Language) {
    this.sendTranslation(language.translationOf(translation))
}

/**
 * Send a [Translation] to a texted audience and
 * acquire the translation by the key from [translation]
 * with specifying formats
 *
 * @since 0.0.9
 * @author kingsthere
 */
fun TextCapable.sendTranslation(translation: Key, language: Language, vararg formats: Any?) {
    this.sendTranslation(language.translationOf(translation), formats)
}