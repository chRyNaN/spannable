# spannable
A Kotlin Common library for defining spannable objects within text.

## Description
A `Span` is an interface defining start and stop indices that it should be applied to within a text.

For instance, given the following String: `"Spannable Text"`, a `Span` could be provided to the word "Spannable" by providing the indices: `startIndexInclusive = 0` and `endIndexExclusive = 9`.

This library allows for creating cross-platform stylized text and the ability to define that text using a DSL approach, such as:
```kotlin
text {
    bold("Spannable") + " Text for Multiplatform " + italic("Kotlin") + " Projects."
}
```

This library does not define specific Spans but provides the base for creating them. 
