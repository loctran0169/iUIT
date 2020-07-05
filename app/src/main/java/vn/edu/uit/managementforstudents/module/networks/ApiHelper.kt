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

    @GET("d9a7d264-cb81-4bc4-9f81-91762c9017a1")
    fun getLichHoc(
        @Query("thu") thu: Int
    ):Call<List<MonHoc>>

    @GET("b05e04a3-2507-4c9c-bae6-8fe73daab6ec")
    fun getNotifyPerson(
        @Query("maSinhVien") maSinhVien: Int
    ):Call<List<NotifyPerson>>


    // lịch học các môn
    //55eb8c93-0d8f-4d61-bf85-f3ecdd8e195d


    // list môn của sinh viên
    //https://run.mocky.io/v3/e9567e99-0e0b-4006-9740-2a724eeb1a60
}