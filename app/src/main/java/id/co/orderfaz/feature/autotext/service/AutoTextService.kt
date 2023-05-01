package id.co.orderfaz.feature.autotext.service

import id.co.orderfaz.core.base.BaseResponseModel
import id.co.orderfaz.feature.autotext.model.ResponseAutoText
import retrofit2.Call
import retrofit2.http.GET

interface AutoTextService {
    @GET("user")
    fun getAll(): Call<BaseResponseModel<ResponseAutoText>>
}