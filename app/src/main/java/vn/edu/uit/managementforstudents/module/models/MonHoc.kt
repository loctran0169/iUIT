package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ThoiKhoaBieu(
    @Expose
    @SerializedName("maTKB")
    var maTKB: Int?,
    @Expose
    @SerializedName("maSinhVien")
    var maSinhVien: Int?,
    @Expose
    @SerializedName("maHocKy")
    var maHocKy: Int?,
    @Expose
    @SerializedName("dayName")
    var dayName: Boolean?,
    @Expose
    @SerializedName("monHoc")
    var mocHoc: List<MonHoc>
)

data class MonHoc(
    var maMonHoc: String?,
    var maLopHoc: String?,
    var tenMonHoc: String?,
    var tenGiaoVien: String?,
    var tenPhong : String?,
    var isMorning : Boolean?,
    var msTeamCode: String?,
    val msTeamDeepLink: String?,
    var thoiGianBatDau: String?,
    var thoiGianKetThuc: String?,
    var ngayBatDau: String?,
    var ngayKetThuc: String?,
    var TC: Int? = 0
) {
    constructor(_maMonHoc: String?, _tenMonHoc: String?) : this(_maMonHoc, "", _tenMonHoc, "", "",true,"", "", "", "", "", "", 0)
}
