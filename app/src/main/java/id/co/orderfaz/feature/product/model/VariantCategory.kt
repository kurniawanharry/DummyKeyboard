package id.co.orderfaz.feature.product.model

import com.google.gson.annotations.SerializedName

data class VariantCategory (

    @SerializedName("name"    ) var name    : String? = null,
    @SerializedName("content" ) var content : String? = null

)