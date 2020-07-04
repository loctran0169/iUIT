package vn.edu.uit.managementforstudents.module.networks

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import vn.edu.uit.managementforstudents.module.models.*

interface ApiHelper {

    @GET("2f07d3d5-3a21-4f3e-a24d-e03dbd9b4da7")
    fun getBangDiem(
        @Query("maSinhVien") studentId: Int
    ): Call<List<Diem>>

    @GET("c1ca40aa-5e78-4f7b-a73a-a4d79923d6c6")
    fun getHocPhi(
        @Query("maSinhVien") studentId: Int
    ): Call<List<HocPhi>>

    @GET("592ed4a1-111d-4cd7-aaae-981f20dc0708")
    fun getThongTinSinhVien(
        @Query("maSinhVien") studentId: Int
    ): Call<ThongTinSinhVien>

    @GET("f8d5a86d-87da-45e4-bbec-c1daa09f1d9d")
    fun getDanhSachMonHoc(
        @Query("maSinhVien") studentId: Int
    ): Call<List<MonHoc>>

    @GET("1b378783-220e-4ada-be9b-82f94ad7b877")
    fun getLichSuHocTap(
        @Query("maSinhVien") studentId: Int,
        @Query("maMonHoc") monHoc: Int?
    ): Call<List<LichSu>>
}