package id.co.orderfaz.feature.product.service

import id.co.orderfaz.core.base.BaseResponseModel
import id.co.orderfaz.feature.product.model.ResponseProduct
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("user")
    fun getAll(@Query("search") search:String, @Query("limit") limit:Int,) : Call<BaseResponseModel<ResponseProduct>>
}