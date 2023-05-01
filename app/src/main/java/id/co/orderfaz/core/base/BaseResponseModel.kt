package id.co.orderfaz.core.base

import com.google.gson.annotations.SerializedName

data class BaseResponseModel<T>(
    @SerializedName("status"     ) var status     : String? = null,
    @SerializedName("statusCode" ) var statusCode : Int?    = null,
    @SerializedName("message"    ) var message    : String? = null,
    @SerializedName("timestamp"  ) var timestamp  : String? = null,
    @SerializedName("data"       ) var data       : T?   = null
)
