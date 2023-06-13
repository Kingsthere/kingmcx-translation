package kingmcx.translation

/**
 * Represent a generic [Language], the default implement for [Language]
 *
 * @since 0.0.9
 * @author kingsthere
 */
data class GenericLanguage(override val available: Boolean, override val name: String,
                           override val displayName: String,
                           override val localizedName: String
) : AbstractTranslationContainer(), Language