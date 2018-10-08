package com.chrynan.spannable

interface SpannableText<T : Span> {

    val text: String

    val spans: List<T>

    fun getSpansFor(startIndexInclusive: Int, endIndexExclusive: Int): List<T>

    fun copy(): SpannableText<T>
}