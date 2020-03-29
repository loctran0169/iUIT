package vn.edu.uit.managementforstudents.data.models

data class NotifyPerson(
    var id: String,
    var context: String,
    var date: String,
    var teacher: String,
    var khoa: String,
    var subject: String,
    var codeSubject: String,
    var phong: String,
    var period_start: String,
    var period_end: String,
    var modified: String,
    var isReading: Boolean
)