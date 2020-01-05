package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)

}

fun Date.add(value: Int, timeUnits: TimeUnits) : Date {
    var time = this.time
    time += when(timeUnits) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY

    }
    this.time = time
    return this
}

fun Date.humanizeDiff() : String {
    var time = this.time
    var currentTime = Date().time
    var diffTime = currentTime - time

    if( 0 < diffTime && diffTime < 1 * SECOND ) {
        return "только что"
    }
    if( 1 * SECOND < diffTime && diffTime < 45 * SECOND ) {
        return "несколько секунд назад"
    }
    if( 45 * SECOND < diffTime && diffTime < 75 * SECOND ) {
        return "минуту назад"
    }
    if( 75 * SECOND < diffTime && diffTime < 45 * MINUTE ) {
        var minutes = diffTime / MINUTE
        return when ("$minutes".last().toString().toLong()) {
            1L -> {
                "$minutes минуту назад"
            }
            in 2L..4L -> {
                "$minutes минуты назад"
            }
            else -> {
                "$minutes минут назад"
            }
        }
    }
    if( 45 * MINUTE < diffTime && diffTime < 75 * MINUTE ) {
        return "час назад"
    }
    if( 75 * MINUTE < diffTime && diffTime < 22 * HOUR ) {
        var hours = diffTime / HOUR
        return when ("$hours".last().toString().toLong()) {
            1L -> {
                "$hours час назад"
            }
            in 2L..4L -> {
                "$hours часа назад"
            }
            else -> {
                "$hours часов назад"
            }
        }

    }
    if( 22 * HOUR < diffTime && diffTime < 26 * HOUR) {
        return "день назад"
    }
    if( 26 * HOUR < diffTime && diffTime < 360 * DAY) {
        var days = diffTime / DAY
        return when ("$days".last().toString().toLong()) {
            1L -> {
                "$days день назад"
            }
            in 2L..4L -> {
                "$days дня назад"
            }
            else -> {
                "$days дней назад"
            }
        }
    }
    if( 360 * DAY < diffTime) {
        return "более года назад"
    }
    return ""
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;
    fun plural(value: Int) : String {
        return when(this.name) {
            SECOND.name ->
                return when ("$value".last().toString().toInt()) {
                    1 -> {
                        "$value секунду"
                    }
                    in 2L..4L -> {
                        "$value секунды"
                    }
                    else -> {
                        "$value секунд"
                    }
                }
            MINUTE.name ->
                return when ("$value".last().toString().toInt()) {
                    1 -> {
                        "$value минуту"
                    }
                    in 2L..4L -> {
                        "$value минуты"
                    }
                    else -> {
                        "$value минут"
                    }
                }
            HOUR.name ->
                return when ("$value".last().toString().toInt()) {
                    1 -> {
                        "$value час"
                    }
                    in 2L..4L -> {
                        "$value часа"
                    }
                    else -> {
                        "$value часов"
                    }
                }
            DAY.name ->
                return when ("$value".last().toString().toInt()) {
                    1 -> {
                        "$value день"
                    }
                    in 2L..4L -> {
                        "$value дня"
                    }
                    else -> {
                        "$value дней"
                    }
                }
            else -> "$value"
        }
    }

}

