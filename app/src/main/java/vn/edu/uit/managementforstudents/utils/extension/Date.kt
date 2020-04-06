package vn.edu.uit.managementforstudents.utils.extension

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun getUTCDateFormat(): DateFormat {
    val pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    val serverDateFormat = SimpleDateFormat(pattern, Locale.US)
    serverDateFormat.timeZone = TimeZone.getTimeZone("UTC")
    return serverDateFormat
}

fun convertTimeZone(date: Date, fromTZ: TimeZone, toTZ: TimeZone): Date {
    var fromTZDst: Long = 0
    if (fromTZ.inDaylightTime(date)) {
        fromTZDst = fromTZ.dstSavings.toLong()
    }

    val fromTZOffset = fromTZ.rawOffset + fromTZDst

    var toTZDst: Long = 0
    if (toTZ.inDaylightTime(date)) {
        toTZDst = toTZ.dstSavings.toLong()
    }
    val toTZOffset = toTZ.rawOffset + toTZDst

    return Date(date.time + (toTZOffset - fromTZOffset))
}

fun getDisplayNameOfMonth(month: Int): String? {
    val c = Calendar.getInstance()
    c.set(Calendar.MONTH, month)
    return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US)
}

fun Long.getDateText(format: String = "MM/dd/yyyy"): String = Date(this).getText(format)

fun Long.toCalendar(): Calendar = Calendar.getInstance().also { it.time = Date(this) }

fun Date.getText(format: String): String {
    val dateResultFormat = SimpleDateFormat(format, Locale.US)
    dateResultFormat.timeZone = TimeZone.getDefault()
    return dateResultFormat.format(this)
}

fun Date.getCurrentDate(): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.time
}

fun Date.getCurrentDay(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.DAY_OF_MONTH)
}

fun Date.getCurrentMonth(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.MONTH)
}

fun Date.getCurrentYear(): Int {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.YEAR)
}

//fun daysOfWeek(startDayOfWeek: Int): List<Int> {
//    val defaultList = ArrayList<Int>()
//    defaultList.add(AppConstants.DAY_MONDAY)//1
//    defaultList.add(AppConstants.DAY_TUESDAY)//2
//    defaultList.add(AppConstants.DAY_WEDNESDAY)//3
//    defaultList.add(AppConstants.DAY_THURSDAY)//4
//    defaultList.add(AppConstants.DAY_FRIDAY)//5
//    defaultList.add(AppConstants.DAY_SATURDAY)//6
//    defaultList.add(AppConstants.DAY_SUNDAY)//0
//    var offset = 0
//    for (i in defaultList.indices) {
//        if (startDayOfWeek == defaultList[i]) {
//            offset = i
//            break
//        }
//    }
//    for (i in 0 until offset) {
//        defaultList.add(defaultList[i])
//    }
//    for (i in 0 until offset) {
//        defaultList.removeAt(0)
//    }
//    return defaultList
//}

fun Date.getStartDay(): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    // reset time
    cal.set(Calendar.AM_PM, Calendar.AM)
    cal.set(Calendar.HOUR, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.MILLISECOND, 0)
    return cal.time
}

fun Date.getEndDay(): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    // reset time
    cal.set(Calendar.AM_PM, Calendar.AM)
    cal.set(Calendar.HOUR, 23)
    cal.set(Calendar.SECOND, 59)
    cal.set(Calendar.MINUTE, 59)
    cal.set(Calendar.MILLISECOND, 999)
    return cal.time
}

fun Date.createDateFromDMY(date: Int, month: Int, year: Int): Date {
    val cal = Calendar.getInstance()

    // reset time
    cal.set(Calendar.AM_PM, Calendar.AM)
    cal.set(Calendar.HOUR, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.MILLISECOND, 0)

    cal.set(Calendar.DATE, date)
    cal.set(Calendar.MONTH, month)
    cal.set(Calendar.YEAR, year)

    return cal.time
}

fun Date.isSameDay(leftDate: Date, rightDate: Date): Boolean {
    val startCalendar = Calendar.getInstance()
    startCalendar.time = leftDate
    val endCalendar = Calendar.getInstance()
    endCalendar.time = rightDate
    return startCalendar.get(Calendar.YEAR) == endCalendar.get(Calendar.YEAR) && startCalendar.get(
        Calendar.DAY_OF_YEAR
    ) == endCalendar.get(Calendar.DAY_OF_YEAR)
}