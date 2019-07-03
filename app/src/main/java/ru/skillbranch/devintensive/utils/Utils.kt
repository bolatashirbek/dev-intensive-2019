package ru.skillbranch.devintensive.utils

object Utils {
    //Переписать данный метод
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trim()?.replaceAll("  ", " ")?.split(" ")

        val firstName = parts?.notEmptyOrNullAt(0)
        val lastName = parts?.notEmptyOrNullAt(1)
        return firstName to lastName
    }

    private fun List<String>.notEmptyOrNullAt(index: Int) = getOrNull(index).let {
        if (it == "") null else it
    }

    private fun String.replaceAll(oldName: String, newName: String): String {
        var value = this
        while (value.contains(oldName)) {
            value = value.replace(oldName, newName)
        }
        return value
    }
}
