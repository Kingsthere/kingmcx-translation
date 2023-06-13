package kingmcx.translation.impl

import kingmc.util.key.Key
import kingmcx.translation.Translation

/**
 * Default implement for [Translation]
 *
 * @since 0.0.9
 * @author kingsthere
 * @see Translation
 */
class TranslationImpl(override val key: Key, override val value: String) : Translation