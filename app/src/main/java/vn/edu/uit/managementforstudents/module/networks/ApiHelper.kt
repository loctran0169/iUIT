package vn.edu.uit.managementforstudents.module.networks

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import vn.edu.uit.managementforstudents.module.models.ScoreTerm

interface ApiHelper {

    @GET("618ba8d6-2836-4286-91f6-25159aad10f3")
    fun getScoreBoard(
        @Query("studentId") studentId: Int
    ): Call<List<ScoreTerm>>
}