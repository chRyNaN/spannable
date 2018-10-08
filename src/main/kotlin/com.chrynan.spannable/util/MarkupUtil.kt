@file:Suppress("unused")

package com.chrynan.spannable.util

import com.chrynan.spannable.*

inline infix fun <reified T : MutableSpan> String.append(other: MutableSpannableText<T>): MutableSpannableText<T> {
    val newText = this + other.text
    val newSpans = other.spans.map {
        it.startIndexInclusive = it.startIndexInclusive + length
        it.endIndexExclusive = it.endIndexExclusive + length
        it
    }

    return MutableSpannableCharSequence(sourceText = newText, sourceSpans = newSpans)
}

inline fun <reified T : Span> spannableTextOf(text: String, spans: List<T> = emptyList()): SpannableText<T> =
        SpannableCharSequence(sourceText = text, sourceSpans = spans)

inline fun <reified T : MutableSpan> mutableSpannableTextOf(text: String, spans: List<T> = emptyList()): MutableSpannableText<T> =
        MutableSpannableCharSequence(sourceText = text, sourceSpans = spans)

inline fun <reified T : MutableSpan> SpannableText<T>.toMutable(): MutableSpannableText<T> =
        MutableSpannableCharSequence(sourceText = text, sourceSpans = spans)

inline fun <reified T : MutableSpan> MutableSpannableText<T>.toImmutable(): SpannableText<T> =
        SpannableCharSequence(sourceText = text, sourceSpans = spans)

inline fun <reified T : MutableSpan> MutableSpannableText<T>.toDeepImmutable(): SpannableText<Span> =
        SpannableCharSequence(sourceText = text, sourceSpans = spans.map { it.copyWithRange() })