package vn.edu.uit.managementforstudents.data.models

data class Subject(
    var id: String?,
    var subjectName: String?,
    var teacherName: String?,
    var teamCode: String?,
    val deepLink: String?,
    var timeStart: String?,
    var timeEnd: String?,
    var dayStart: String?,
    var dayEnd: String?
)