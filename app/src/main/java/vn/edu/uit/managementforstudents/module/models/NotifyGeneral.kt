package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data  class NotifyGeneral (
    @Expose
    @SerializedName("id")
    val id: Int?,
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("date")
    val date: String?,
    @Expose
    @SerializedName("link")
    val link: String?
)