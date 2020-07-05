package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LichSu(
    @Expose
    @SerializedName("maLichSu")
    var maLichSu : Int?,
    @Expose
    @SerializedName("siSo")
    var siSo : Int?,
    @Expose
    @SerializedName("soThanhVien")
    var soThanhVien : Int?,
    @Expose
    @SerializedName("thoiGianBatDau")
    var thoiGianBatDau : String?,
    @Expose
    @SerializedName("thoiGianKetThuc")
    var thoiGianKetThuc : String?,
    @Expose
    @SerializedName("trangThai")
    var trangThai : Boolean?,
    @Expose
    @SerializedName("phuongThuc")
    var phuongThuc: String?,
    @Expose
    @SerializedName("noiDung")
    var noiDung : String?,
    @Expose
    @SerializedName("yeuCau")
    var yeuCau : String?,
    @Expose
    @SerializedName("recordVideo")
    var recordVideo : String?,
    @Expose
    @SerializedName("monHoc")
    var monHoc : MonHoc?
)