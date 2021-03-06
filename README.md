# spannable
A Kotlin Common library for defining spannable objects within text.

This library is accessible using [Jitpack](https://jitpack.io/#chRyNaN/spannable/v1.0.0-SNAPSHOT): [![](https://jitpack.io/v/chRyNaN/spannable.svg)](https://jitpack.io/#chRyNaN/spannable)

**Kotlin Common Project:**
```
implementation 'com.github.chRyNaN.spannable:spannable-common:VERSION'
```
**JVM Project:**
```
implementation 'com.github.chRyNaN.spannable:spannable-jvm:VERSION'
```
**JS Project:**
```
implementation 'com.github.chRyNaN.spannable:spannable-js:VERSION'
```

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
