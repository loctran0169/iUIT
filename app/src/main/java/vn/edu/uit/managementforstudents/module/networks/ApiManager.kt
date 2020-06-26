package vn.edu.uit.managementforstudents.module.networks

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.edu.uit.managementforstudents.module.models.ScoreTerm

class ApiManager {

    private val _apiRestFull: ApiHelper by lazy {
        getHelperRestFull()!!.create(ApiHelper::class.java)
    }

    companion object {

        private var sRestFull: Retrofit? = null

        fun getHelperRestFull(): Retrofit? {
            if (sRestFull == null) {
                sRestFull = Retrofit
                    .Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return sRestFull
        }
    }

    private fun <T : Any> buildRequest(call: Call<T>): Single<T> {
        return Single.create {
            call.enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    try {
                        it.onSuccess(response.body()!!)
                    } catch (ex: Exception) {

                    }
                }

                override fun onFailure(p0: Call<T>, response: Throwable) {
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
    fun getScoreBoard(_id : Int): Single<List<ScoreTerm>> {
        return buildRequest(_apiRestFull.getScoreBoard(_id))
    }
}