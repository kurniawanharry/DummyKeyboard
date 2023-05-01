package id.co.orderfaz.feature.rate.service

import android.icu.text.StringSearch
import id.co.orderfaz.core.base.BaseResponseModel
import id.co.orderfaz.feature.autotext.model.ResponseAutoText
import id.co.orderfaz.feature.rate.model.Location
import id.co.orderfaz.feature.rate.model.RequestRate
import id.co.orderfaz.feature.rate.model.ResponseRate
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RateService {
    @GET("location")
    fun searchLocation(@Query("search") search:String, @Query("limit") limit:Int,): Call<BaseResponseModel<ArrayList<Location>>>

    @POST("rates")
     fun createRate(@Body requestRate: RequestRate) : Call<BaseResponseModel<ArrayList<ResponseRate>>>

}