package id.co.orderfaz.feature.autotext.model

import com.google.gson.annotations.SerializedName

data class AutoTexts(
    @SerializedName("id"          ) var id          : String?  = null,
    @SerializedName("name"        ) var name        : String?  = null,
    @SerializedName("content"     ) var content     : String?  = null,
    @SerializedName("isDefault"   ) var isDefault   : Boolean? = null,
    @SerializedName("isActive"    ) var isActive    : Boolean? = null,
    @SerializedName("isSuspended" ) var isSuspended : Boolean? = null,
    @SerializedName("text"        ) var text        : String?  = null,
    @SerializedName("createdAt"   ) var createdAt   : String?  = null,
    @SerializedName("createdBy"   ) var createdBy   : String?  = null
)