package com.chrynan.spannable

open class SpannableCharSequence<T : Span>(
        sourceText: CharSequence,
        sourceSpans: List<T> = emptyList()
) : SpannableText<T>,
        CharSequence {

    override val text = sourceText.toString()

    override val spans = sourceSpans

    override val length
        get() = text.length

    override fun getSpansFor(startIndexInclusive: Int, endIndexExclusive: Int) =
            spans.filter { (startIndexInclusive >= it.startIndexInclusive) and (endIndexExclusive <= it.endIndexExclusive) }

    @Suppress("UNCHECKED_CAST")
    override fun copy() =
            SpannableCharSequence(
                    sourceText = text,
                    sourceSpans = spans.map { it.copyWithRange() as T })

    override fun get(index: Int) = text[index]

    override fun subSequence(startIndex: Int, endIndex: Int): SpannableCharSequence<T> = SpannableCharSequence(
            sourceText = text.subSequence(startIndex = startIndex, endIndex = endIndex),
            sourceSpans = getSpansFor(startIndexInclusive = startIndex, endIndexExclusive = endIndex))

    @Suppress("UNCHECKED_CAST")
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        if (this::class != other::class) return false

        val castedOther = try {
            (other as? SpannableCharSequence<T>)
        } catch (e: Exception) {
            null
        }

        val textEqual = text == castedOther?.text
        val spansEqual = spans.sortedBy { it.startIndexInclusive } == castedOther?.spans?.sortedBy { it.startIndexInclusive }

        return textEqual and spansEqual
    }

    override fun hashCode() = text.hashCode() + spans.hashCode()

    override fun toString() = text
}