package com.chrynan.spannable

interface MutableSpan : Span {

    override var startIndexInclusive: Int

    override var endIndexExclusive: Int

    override fun copyWithRange(startInclusive: Int, endExclusive: Int): MutableSpan
}