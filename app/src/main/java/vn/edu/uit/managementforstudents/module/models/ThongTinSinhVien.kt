package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ThongTinSinhVien(
    @Expose
    @SerializedName("maSinhVien")
    var maSinhVien : String?,
    @Expose
    @SerializedName("hoTen")
    var hoTen : String?,
    @Expose
    @SerializedName("ngaySinh")
    var ngaySinh : String?,
    @Expose
    @SerializedName("gioiTinh")
    var gioiTinh : String?,
    @Expose
    @SerializedName("email")
    var email : String?,
    @Expose
    @SerializedName("nganh")
    var nganh : String?,
    @Expose
    @SerializedName("lop")
    var lop : String?,
    @Expose
    @SerializedName("sdt")
    var sdt : String?,
    @Expose
    @SerializedName("diaChi")
    var diaChi : String?,
    @Expose
    @SerializedName("facebook")
    var facebook : String?,
    @Expose
    @SerializedName("avatar")
    var avatar : String?
)