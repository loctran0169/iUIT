package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DiemDanh (
    @Expose
    @SerializedName("maLopHoc")
    var maLopHoc : String?,
    @Expose
    @SerializedName("maDiemDanh")
    var maDiemDanh : String?
)