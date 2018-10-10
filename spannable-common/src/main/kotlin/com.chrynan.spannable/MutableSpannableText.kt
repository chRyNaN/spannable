package com.chrynan.spannable

interface MutableSpannableText<T : MutableSpan> : SpannableText<T> {

    override var text: String

    override var spans: MutableList<T>

    operator fun plus(other: SpannableText<T>): MutableSpannableText<T>

    operator fun plus(other: String): MutableSpannableText<T>
}