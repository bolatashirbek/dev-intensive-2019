package ru.skillbranch.devintensive.extensions

fun String.truncate(size: Int = 16): String {
    val result = this.trim()
    if (result.length <= size) return result
    return result.substring(0, size).trimEnd() + "..."
}
