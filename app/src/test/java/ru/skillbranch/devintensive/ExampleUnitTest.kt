package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils.toInitials
import ru.skillbranch.devintensive.utils.Utils.transliteration
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
         assertEquals(toInitials("john" ,"doe"), "JD") //JD
         assertEquals(toInitials("John", null),"J")
         assertEquals(toInitials(null, null) ,"null")
         assertEquals(toInitials(" ", "") ,"null")
         assertEquals(transliteration("Женя Стереотипов"), "Zhenya Stereotipov")
         assertEquals(transliteration("Amazing Петр","_"), "Amazing_Petr")
         assertEquals(Date().add(-2, TimeUnits.HOUR).humanizeDiff(), "2 часа назад")
         assertEquals(Date().add(-5, TimeUnits.DAY).humanizeDiff() ,"5 дней назад")
//         assertEquals(Date().add(2, TimeUnits.MINUTE).humanizeDiff(), "через 2 минуты")
//         assertEquals(Date().add(7, TimeUnits.DAY).humanizeDiff(), "через 7 дней")
         assertEquals(Date().add(-400, TimeUnits.DAY).humanizeDiff(), "более года назад")
//         assertEquals(Date().add(400, TimeUnits.DAY).humanizeDiff(), "более чем через год")
        User.Builder().id("1")
            .firstName("John")
            .lastName("Стереотипов")
            .avatar("ava")
            .rating(0)
            .respect(0)
            .lastVisit(Date())
            .isOnline(true)
            .build()
        assertEquals(TimeUnits.SECOND.plural(1),"1 секунду")
        assertEquals(TimeUnits.MINUTE.plural(4),"4 минуты")
        assertEquals(TimeUnits.HOUR.plural(19), "19 часов")
        assertEquals(TimeUnits.DAY.plural(222), "222 дня")
        assertEquals("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(), "Bender Bending R...")
        assertEquals("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15), "Bender Bending...")
        assertEquals("A     ".truncate(3),"A")
         assertEquals("<p class='title'>Образовательное IT-сообщество Skill Branch</p>".stripHtml(), "Образовательное IT-сообщество Skill Branch")
         assertEquals("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml() ,"Образовательное IT-сообщество Skill Branch")
    }
}
