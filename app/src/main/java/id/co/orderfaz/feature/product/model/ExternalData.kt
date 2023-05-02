package id.co.orderfaz.feature.product.model
import com.google.gson.annotations.SerializedName

data class ExternalData (
    @SerializedName("externalProductId" ) var externalProductId : String? = null,
    @SerializedName("externalShopId"    ) var externalShopId    : String? = null,
    @SerializedName("externalSourceId"  ) var externalSourceId  : Int?    = null
)

