package kingmcx.translation

/**
 * Throw when creating a language with invalid name or
 * getting a language that not exist
 *
 * @since 0.0.9
 * @author kingsthere
 */
class InvalidLanguageException(message: String?) : RuntimeException(message)