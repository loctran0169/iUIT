package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Diem(
    @Expose
    @SerializedName("maBangDiem")
    var maBangDiem : Int?,
    @Expose
    @SerializedName("maSinhVien")
    var maSinhVien : Int?,
    @Expose
    @SerializedName("tenHocKy")
    var tenHocKy : String?,
    @SerializedName("list")
    var diem : List<DiemMonHoc>
)

data class DiemMonHoc(
    @Expose
    @SerializedName("MaMH")
    val MaMH: String?,
    @Expose
    @SerializedName("TenMH")
    val TenMH: String?,
    @Expose
    @SerializedName("TC")
    val TC: String?,
    @Expose
    @SerializedName("QT")
    val QT: String?,
    @Expose
    @SerializedName("TH")
    val TH: String?,
    @Expose
    @SerializedName("GK")
    val GK: String?,
    @Expose
    @SerializedName("CK")
    val CK: String?,
    @Expose
    @SerializedName("TB")
    val TB: String?
)