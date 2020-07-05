package vn.edu.uit.managementforstudents.module.networks

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.edu.uit.managementforstudents.module.models.*
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

class ApiManager {

    private val _apiRestFull: ApiHelper by lazy {
        getHelperRestFull()!!.create(ApiHelper::class.java)
    }

    companion object {

        private var sRestFull: Retrofit? = null
        private var sOkHttpClient: OkHttpClient? = null
        fun getOkHttpClient(): OkHttpClient? {
            if (sOkHttpClient == null) {
                sOkHttpClient = OkHttpClient.Builder()
                    .readTimeout(8,TimeUnit.SECONDS)
                    .connectTimeout(8,TimeUnit.SECONDS)
                    .build()
            }
            return sOkHttpClient
        }
        private var client = OkHttpClient()

        fun getHelperRestFull(): Retrofit? {
            if (sRestFull == null) {
                sRestFull = Retrofit
                    .Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build()
            }
            return sRestFull
        }
    }

    private fun <T : Any> buildRequest(call: Call<T>): Single<T> {
        return Single.create {
            call.enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    println("### resp ${response.isSuccessful} ${response.code()}")
                    try {
                        it.onSuccess(response.body()!!)
                    } catch (ex: Exception) {

                    }
                }

                override fun onFailure(p0: Call<T>, response: Throwable) {
                    if(response is SocketTimeoutException)
                        println("### fail ${response.message}")
                    it.onError(response)
                }

            })
        }
    }

    private fun <Bitmap : Any> buildImage(call: Call<Bitmap>): Single<Bitmap> {
        return Single.create {
            call.enqueue(object : Callback<Bitmap> {
                override fun onResponse(call: Call<Bitmap>, response: Response<Bitmap>) {
                    try {
                        it.onSuccess(response.body()!!)
                    } catch (ex: Exception) {

                    }
                }

                override fun onFailure(p0: Call<Bitmap>, response: Throwable) {
                    it.onError(response)
                }
            })
        }
    }

    fun getScoreBoard(_id : Int): Single<List<Diem>> {
        return buildRequest(_apiRestFull.getBangDiem(_id))
    }

    fun getHocPhi(_id : Int): Single<List<HocPhi>> {
        return buildRequest(_apiRestFull.getHocPhi(_id))
    }

    fun getThongTinSinhVien(_id : Int): Single<ThongTinSinhVien> {
        return buildRequest(_apiRestFull.getThongTinSinhVien(_id))
    }

    fun getDanhSachMonHoc(_id : Int): Single<List<MonHoc>> {
        return buildRequest(_apiRestFull.getDanhSachMonHoc(_id))
    }

    fun getLichSuHocTap(_id : Int, _maMonHoc: Int?): Single<List<LichSu>> {
        return buildRequest(_apiRestFull.getLichSuHocTap(_id,_maMonHoc))
    }

    fun getSchedule(_id : Int, _maHocKy: Int?): Single<List<ThoiKhoaBieu>> {
        return buildRequest(_apiRestFull.getSchedule(_id,_maHocKy))
    }
}