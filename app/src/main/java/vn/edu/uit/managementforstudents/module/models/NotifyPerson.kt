package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NotifyPerson(
    @Expose
    @SerializedName("id")
    val id: String?,
    @Expose
    @SerializedName("context")
    val context: String?,
    @Expose
    @SerializedName("date")
    val date: String?,
    @Expose
    @SerializedName("teacher")
    val teacher: String?,
    @Expose
    @SerializedName("khoa")
    val khoa: String?,
    @Expose
    @SerializedName("subject")
    val subject: String?,
    @Expose
    @SerializedName("codeSubject")
    val codeSubject: String?,
    @Expose
    @SerializedName("phong")
    val phong: String?,
    @Expose
    @SerializedName("period_start")
    val period_start: String?,
    @Expose
    @SerializedName("period_end")
    val period_end: String?,
    @Expose
    @SerializedName("modified")
    val modified: String?,

    var isReading: Boolean=false
)