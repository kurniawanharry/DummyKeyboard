package id.co.orderfaz.feature.rate.model

import com.google.gson.annotations.SerializedName


data class RequestRate (

    @SerializedName("checkoutId"                 ) var checkoutId                 : String?  = null,
    @SerializedName("destinationLatitude"        ) var destinationLatitude        : Double?  = null,
    @SerializedName("destinationLongitude"       ) var destinationLongitude       : Double?  = null,
    @SerializedName("destinationPostalCode"      ) var destinationPostalCode      : String?  = null,
    @SerializedName("destinationSubDistrictName" ) var destinationSubDistrictName : String?  = null,
    @SerializedName("isCod"                      ) var isCod                      : Boolean? = null,
    @SerializedName("isUseInsurance"             ) var isUseInsurance             : Boolean? = null,
    @SerializedName("itemPrice"                  ) var itemPrice                  : Int?     = null,
    @SerializedName("originLatitude"             ) var originLatitude             : Double?  = null,
    @SerializedName("originLongitude"            ) var originLongitude            : Double?  = null,
    @SerializedName("originPostalCode"           ) var originPostalCode           : String?  = null,
    @SerializedName("originSubDistrictName"      ) var originSubDistrictName      : String?  = null,
    @SerializedName("packageTypeId"              ) var packageTypeId              : Int?     = null,
    @SerializedName("shipmentType"               ) var shipmentType               : String?  = null,
    @SerializedName("weight"                     ) var weight                     : Int?     = null,
    @SerializedName("height"                     ) var height                     : Int?     = null,
    @SerializedName("length"                     ) var length                     : Int?     = null,
    @SerializedName("width"                      ) var width                      : Int?     = null

)