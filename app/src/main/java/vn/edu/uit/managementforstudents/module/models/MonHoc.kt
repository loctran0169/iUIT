package vn.edu.uit.managementforstudents.module.models

data class MonHoc(
    var maMonHoc: String?,
    var maLopHoc: String?,
    var tenMonHoc: String?,
    var tenGiaoVien: String?,
    var msTeamCode: String?,
    val msTeamDeepLink: String?,
    var thoiGianBatDau: String?,
    var thoiGianKetThuc: String?,
    var ngayBatDau: String?,
    var ngayKetThuc: String?,
    var TC : Int?=0
){
    constructor(_maMonHoc: String?,_tenMonHoc: String?) : this(_maMonHoc,"",_tenMonHoc,"","","","","","","",0)
}