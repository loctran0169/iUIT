package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class MonHoc(
    @Expose
    @SerializedName("maMonHoc")
    val maMonHoc: String?,
    @Expose
    @SerializedName("maLopHoc")
    val maLopHoc: String?,
    @Expose
    @SerializedName("tenMonHoc")
    val tenMonHoc: String?,
    @Expose
    @SerializedName("tenGiaoVien")
    val tenGiaoVien: String?,
    @Expose
    @SerializedName("msTeamCode")
    val msTeamCode: String?,
    @Expose
    @SerializedName("msTeamDeepLink")
    val msTeamDeepLink: String?,
    @Expose
    @SerializedName("phongHoc")
    val phongHoc: String?,
    @Expose
    @SerializedName("thu")
    val thu: Int?,
    @Expose
    @SerializedName("thoiGianBatDau")
    val thoiGianBatDau: String?,
    @Expose
    @SerializedName("thoiGianKetThuc")
    val thoiGianKetThuc: String?,
    @Expose
    @SerializedName("ngayBatDau")
    val ngayBatDau: String?,
    @Expose
    @SerializedName("ngayKetThuc")
    val ngayKetThuc: String?,
    @Expose
    @SerializedName("TC")
    val TC: Int?

)