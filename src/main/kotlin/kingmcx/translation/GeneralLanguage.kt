package kingmcx.translation

/**
 * This object represent the general translation container
 * that could apply for every [LanguageCapable], everyone
 * receive the general language same
 *
 * @since 0.0.9
 * @author kingsthere
 * @see TranslationContainer
 */
object GeneralLanguage : AbstractTranslationContainer(), Language {
    /**
     * Is this language available
     *
     * @since 0.0.9
     */
    override val available: Boolean = true

    /**
     * The name of this language, also
     * the only identifier of languages
     *
     * @since 0.0.9
     */
    override val name: String = "general"
    override val displayName: String = "General"
    override val localizedName: String = "General"
}