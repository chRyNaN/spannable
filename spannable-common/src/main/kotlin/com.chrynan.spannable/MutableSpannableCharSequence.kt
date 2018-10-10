package com.chrynan.spannable

class MutableSpannableCharSequence<T : MutableSpan>(
        sourceText: CharSequence,
        sourceSpans: List<T> = emptyList()
) : SpannableCharSequence<T>(
        sourceText = sourceText,
        sourceSpans = sourceSpans
), MutableSpannableText<T> {

    override var text: String = sourceText.toString()

    override var spans: MutableList<T> = sourceSpans as? MutableList<T> ?: sourceSpans.toMutableList()

    override fun subSequence(startIndex: Int, endIndex: Int): MutableSpannableCharSequence<T> = MutableSpannableCharSequence(
            sourceText = text.subSequence(startIndex = startIndex, endIndex = endIndex),
            sourceSpans = getSpansFor(startIndexInclusive = startIndex, endIndexExclusive = endIndex))

    override fun plus(other: SpannableText<T>): MutableSpannableText<T> {
        val newText = text + other.text
        val newOtherSpans = other.spans.map {
            it.startIndexInclusive = it.startIndexInclusive + length
            it.endIndexExclusive = it.endIndexExclusive + length
            it
        }
        val newSpans: List<T> = spans + newOtherSpans

        return MutableSpannableCharSequence(sourceText = newText, sourceSpans = newSpans)
    }

    override fun plus(other: String) =
            MutableSpannableCharSequence(sourceText = text + other, sourceSpans = spans)
}