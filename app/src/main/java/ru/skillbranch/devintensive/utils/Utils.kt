package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?) : Pair<String?, String?> {
        val parts : List<String>? = fullName?.split(" ")
        val firstName = parts?.get(0)
        val lastName = parts?.get(1)
        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?) : String {
        var initials = "${if(firstName?.trimEnd()?.isNotEmpty() == true) firstName?.trimEnd()?.get(0)?.toUpperCase() else ""}" +
                "${if(lastName?.trimEnd()?.isNotEmpty() == true) lastName?.trimEnd()?.get(0)?.toUpperCase() else ""}"
        return if(initials?.length > 0) initials else "null"
    }

    fun transliteration(payload : String?, divider : String? = " ") =
        payload?.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ]")) {
            when (it.value) {
                "а"->"a"
                "б"->"b"
                "в"->"v"
                "г"->"g"
                "д"->"d"
                "е"->"e"
                "ё"->"e"
                "ж"->"zh"
                "з"->"z"
                "и"->"i"
                "й"->"i"
                "к"->"k"
                "л"->"l"
                "м"->"m"
                "н"->"n"
                "о"->"o"
                "п"->"p"
                "р"->"r"
                "с"->"s"
                "т"->"t"
                "у"->"u"
                "ф"->"f"
                "х"->"h"
                "ц"->"c"
                "ч"->"ch"
                "ш"->"sh"
                "щ"->"sh'"
                "ъ"->""
                "ы"->"i"
                "ь"->""
                "э"->"e"
                "ю"->"yu"
                "я"->"ya"
                "А"->"A"
                "Б"->"B"
                "В"->"V"
                "Г"->"G"
                "Д"->"D"
                "Е"->"E"
                "Ё"->"E"
                "Ж"->"Zh"
                "З"->"Z"
                "И"->"I"
                "Й"->"I"
                "К"->"K"
                "Л"->"L"
                "М"->"M"
                "Н"->"N"
                "О"->"O"
                "П"->"P"
                "Р"->"R"
                "С"->"S"
                "Т"->"T"
                "У"->"U"
                "Ф"->"F"
                "Х"->"H"
                "Ц"->"C"
                "Ч"->"Ch"
                "Ш"->"Sh"
                "Щ"->"Sh'"
                "Ъ"->""
                "Ы"->"I"
                "Ь"->""
                "Э"->"E"
                "Ю"->"Yu"
                "Я"->"Ya"
                " "-> "$divider"
                else -> it.value
            }
        }

}