package com.chrynan.spannable

interface Span {

    val startIndexInclusive: Int

    val endIndexExclusive: Int

    fun copyWithRange(startInclusive: Int = startIndexInclusive, endExclusive: Int = endIndexExclusive): Span
}