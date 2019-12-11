package ru.skillbranch.devintensive.extensions

fun String.truncate(charNumber: Int=16) : String {
    var result = this.trimEnd()
    if(result.length > charNumber) {
        return "${result.substring(0, charNumber).trimEnd()}..."
    }
    return result
}

fun String.stripHtml(charNumber: Int=16) : String {
    return this.replace(Regex("\\<[^>]*>"), "").replace("\\s+".toRegex(), " ")
}