package kingmcx.translation

import kingmc.common.context.annotation.Bean
import kingmc.platform.extension.Extension
import kingmc.platform.extensionFile

/**
 * Main extension class
 */
@Extension(
    id = "translation",
    name = "Translation",
    tag = "0.1.0",
    description = Extension.Description(
        contributors = ["Kingsthere"],
        introduction = "An extension allow translate message in game",
        website = "https://www.kingmc.com"
    ),
    dependencies = [
        Extension.Dependency("configuration", optional = false),
        Extension.Dependency("persistence", optional = false),
    ]
)
object TranslationExtension {
    /**
     * Add `LanguageFactory` to context
     */
    @Bean
    fun fileLanguageFactory(): LanguageFactory {
        return FileLanguageFactory(extensionFile("language/"))
    }
}