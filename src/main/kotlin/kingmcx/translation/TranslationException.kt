package kingmcx.translation

/**
 * This exception thrown when the translation is
 * invalid or injecting a translation into a
 * immutable [TranslationContainer]
 *
 * @since 0.0.9
 * @author kingsthere
 * @see Exception
 * @see RuntimeException
 * @see Throwable
 */
class TranslationException(message: String?) : RuntimeException(message)