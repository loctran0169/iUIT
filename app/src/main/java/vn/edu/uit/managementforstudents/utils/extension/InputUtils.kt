package vn.edu.uit.managementforstudents.utils.extension

import android.text.TextUtils
import java.util.regex.Pattern


fun String.isEmailValid(): Boolean {
    if (TextUtils.isEmpty(this)) return false

    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"

    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun isPasswordValid(password: String): Boolean {
    if (TextUtils.isEmpty(password)) return false

    val expression = "(?=.*[A-Z a-z])(?=.*[0-9]).{8,20}"

    val pattern = Pattern.compile(expression)
    val matcher = pattern.matcher(password)
    return matcher.matches()
}

fun isLengthDecimalValid(value: Double, roundTo: Int): Boolean {
    val expression = "^([0-9])(\\.[0-9]{1,2})?\$"
    val pattern = Pattern.compile(expression)
    val matcher = pattern.matcher(value.toString())
    return matcher.matches()
}