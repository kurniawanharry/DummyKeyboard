package id.co.orderfaz.feature.product.model

import com.google.gson.annotations.SerializedName


data class ProductBump (

    @SerializedName("id"          ) var id          : String? = null,
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("productName" ) var productName : String? = null,
    @SerializedName("imageUrl"    ) var imageUrl    : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("price"       ) var price       : Int?    = null,
    @SerializedName("weight"      ) var weight      : Int?    = null,
    @SerializedName("width"       ) var width       : Int?    = null,
    @SerializedName("length"      ) var length      : Int?    = null,
    @SerializedName("height"      ) var height      : Int?    = null,
    @SerializedName("type"        ) var type        : Int?    = null

)