package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DangNhap (
    @Expose
    @SerializedName("status")
    var status : String?,

    @SerializedName("list")
    var thongTinSinhVien : List<ThongTinSinhVien>
)