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

    @GET("bc30498f-59c5-4bda-a11b-1ab3411f66f8")
    fun getDanhSachMonHoc(
        @Query("maSinhVien") studentId: Int
    ): Call<List<MonHoc>>

    // HDH
    @GET("6873fcbe-e4dc-4f5d-ad77-916fa9bb76ac")
    fun getLichSuHocTap(
        @Query("maSinhVien") studentId: Int,
        @Query("maMonHoc") monHoc: Int?
    ): Call<List<LichSu>>

    @GET("f42569bc-c75e-40c4-aedd-88de26e04fed")
    fun getLichSuHocTapHeDieuHanh(
        @Query("maSinhVien") studentId: Int,
        @Query("maMonHoc") monHoc: Int?
    ): Call<List<LichSu>>

    @GET("51253f15-7944-4013-8fb3-567dd298731d")
    fun getLichSuHocTapHeDieuHanhTH(
        @Query("maSinhVien") studentId: Int,
        @Query("maMonHoc") monHoc: Int?
    ): Call<List<LichSu>>

    @GET("5f559fca-5758-4746-894e-ce2af4e81b4a")
    fun getLichSuHocTapGame(
        @Query("maSinhVien") studentId: Int,
        @Query("maMonHoc") monHoc: Int?
    ): Call<List<LichSu>>

    @GET("e3b44eef-8fcf-4b61-a6ef-bd218b765946")
    fun getLichSuHocTapPLDC(
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
    ): Call<List<NotifyPerson>>

    @GET("5b06acb2-5008-4959-9aef-bf0a590fca1b")
    fun getNotifyGeneral(
        @Query("maSinhVien") maSinhVien: Int
    ): Call<List<NotifyGeneral>>

    @GET("18cb5b29-9283-4a35-90f6-7230b3c4afa7")
    fun getLoginResponse(
        @Query("maSinhVien") maSinhVien: Int
    ):Call<List<DangNhap>>

    @GET("18cb5b29-9283-4a35-90f6-7230b3c4afa7")
    fun getForgotPasswordResponse(
        @Query("maSinhVien") maSinhVien: Int
    ):Call<List<DangNhap>>

    @GET("2597ad05-8409-4c82-b1ba-22ee14b1d17c")
    fun getDiemDanh(
        @Query("maLopHoc") maLopHoc: String
    ):Call<List<DiemDanh>>



}