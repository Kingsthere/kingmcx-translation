package kingmcx.translation

/**
 * Represent a language, a type of translation that
 * is available or not, the unique identifier of
 * [Language] is [name]
 *
 * @since 0.0.9
 * @author kingsthere
 * @see available
 * @see name
 */
interface Language : TranslationContainer {
    /**
     * Is this language available
     *
     * @since 0.0.9
     */
    val available: Boolean

    /**
     * The name of this language, also the only identifier of languages, this
     * field should follow the pattern
     *
     * @since 0.0.9
     */
    val name: String

    /**
     * The display name of this language in **english**, the
     * display name is the display name for human visual, it
     * should contain capital letters and space instead of
     * underline
     *
     * @since 0.0.9
     */
    val displayName: String

    /**
     * The localized name of this language in **the locale this
     * language instance is specifying**, the
     * localized name is the display name for human visual, it
     * should contain capital letters and space instead of
     * underline
     *
     * @since 0.0.9
     */
    val localizedName: String
}