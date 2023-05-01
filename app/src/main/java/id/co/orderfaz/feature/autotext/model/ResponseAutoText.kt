package id.co.orderfaz.feature.autotext.model

import com.google.gson.annotations.SerializedName


data class ResponseAutoText (

    @SerializedName("autoTexts"  ) var autoTexts  : ArrayList<AutoTexts> = arrayListOf(),
    @SerializedName("pagination" ) var pagination : Pagination?          = Pagination()

)
