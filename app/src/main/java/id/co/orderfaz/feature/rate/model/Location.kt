package id.co.orderfaz.feature.rate.model

import com.google.gson.annotations.SerializedName


data class Location (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("postalCode"  ) var postalCode  : String? = null,
    @SerializedName("subDistrict" ) var subDistrict : String? = null,
    @SerializedName("district"    ) var district    : String? = null,
    @SerializedName("city"        ) var city        : String? = null,
    @SerializedName("province"    ) var province    : String? = null

)