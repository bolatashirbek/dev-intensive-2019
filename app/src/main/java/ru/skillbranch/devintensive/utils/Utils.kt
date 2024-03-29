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

    fun toInitials(firstName: String?, lastName: String?): String? {
        val first = firstName?.trim()?.capitalize()?.getOrNull(0)
        val last = lastName?.trim()?.capitalize()?.getOrNull(0)
        return if (first == null && last == null) null else "${first ?: ""}${last ?: ""}"
    }

    fun transliteration(payload: String, divider: String = " "): String = buildString {
        payload.asSequence().forEach {
            append(if (it == ' ') divider else it.transliterate())
        }
    }

    private fun Char.transliterate(): String {
        return if (isUpperCase()) {
            chars[this.toLowerCase()]?.toUpperCase() ?: this.toString()
        } else {
            chars[this] ?: this.toString()
        }
    }

    private val chars = mapOf(
        'а' to "a",
        'б' to "b",
        'в' to "v",
        'г' to "g",
        'д' to "d",
        'е' to "e",
        'ё' to "e",
        'ж' to "zh",
        'з' to "z",
        'и' to "i",
        'й' to "i",
        'к' to "k",
        'л' to "l",
        'м' to "m",
        'н' to "n",
        'о' to "o",
        'п' to "p",
        'р' to "r",
        'с' to "s",
        'т' to "t",
        'у' to "u",
        'ф' to "f",
        'х' to "h",
        'ц' to "c",
        'ч' to "ch",
        'ш' to "sh",
        'щ' to "sh'",
        'ъ' to "",
        'ы' to "i",
        'ь' to "",
        'э' to "e",
        'ю' to "yu",
        'я' to "ya"
    )


}
