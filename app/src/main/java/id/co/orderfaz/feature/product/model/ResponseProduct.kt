package id.co.orderfaz.feature.product.model

import com.google.gson.annotations.SerializedName
import id.co.orderfaz.feature.autotext.model.Pagination

data class ResponseProduct (
    @SerializedName("products"   ) var products   : ArrayList<Products> = arrayListOf(),
    @SerializedName("pagination" ) var pagination : Pagination?         = Pagination()

)