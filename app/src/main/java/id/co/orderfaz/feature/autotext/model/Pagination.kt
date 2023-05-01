package id.co.orderfaz.feature.autotext.model

import com.google.gson.annotations.SerializedName



data class Pagination (

    @SerializedName("total"       ) var total       : Int? = null,
    @SerializedName("perPage"     ) var perPage     : Int? = null,
    @SerializedName("currentPage" ) var currentPage : Int? = null,
    @SerializedName("lastPage"    ) var lastPage    : Int? = null

)
