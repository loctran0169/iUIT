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

    @GET("fbfed6a5-1b4d-411a-8194-4eb4632fcfba")
    fun getLichSuHocTap(
        @Query("maSinhVien") studentId: Int,
        @Query("maMonHoc") monHoc: Int?
    ): Call<List<LichSu>>

    @GET("0e8bb4ca-401d-44cb-91a5-96446c978c06")
    fun getSchedule(
        @Query("maSinhVien") studentId: Int,
        @Query("maHocKy") monHoc: Int?
    ): Call<List<ThoiKhoaBieu>>

    @GET("b05e04a3-2507-4c9c-bae6-8fe73daab6ec")
    fun getNotifyPerson(
        @Query("maSinhVien") maSinhVien: Int
    ):Call<List<NotifyPerson>>
}