package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HocPhi(
    @Expose
    @SerializedName("idTerm")
    var maHocPhi : Int?,
    @Expose
    @SerializedName("maSinhVien")
    var maSinhVien : Int?,
    @Expose
    @SerializedName("tenHocKy")
    var tenHocKy : String?,
    @Expose
    @SerializedName("thanhToan")
    var thanhToan : Boolean?,
    @Expose
    @SerializedName("hocPhi")
    var hocPhi : Int?,
    @SerializedName("monHoc")
    var mocHoc : List<MonHoc>
)