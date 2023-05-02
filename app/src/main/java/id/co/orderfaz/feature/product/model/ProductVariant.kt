package id.co.orderfaz.feature.product.model

import com.google.gson.annotations.SerializedName

data class ProductVariant(
    @SerializedName("id"              ) var id              : String?                    = null,
    @SerializedName("variantName"     ) var variantName     : String?                    = null,
    @SerializedName("variantSKU"      ) var variantSKU      : String?                    = null,
    @SerializedName("variantStock"    ) var variantStock    : Int?                       = null,
    @SerializedName("variantPrice"    ) var variantPrice    : Int?                       = null,
    @SerializedName("variantDiscount" ) var variantDiscount : Int?                       = null,
    @SerializedName("variantCOGS"     ) var variantCOGS     : String?                    = null,
    @SerializedName("variantWeight"   ) var variantWeight   : Int?                       = null,
    @SerializedName("variantHeight"   ) var variantHeight   : String?                    = null,
    @SerializedName("variantWidth"    ) var variantWidth    : String?                    = null,
    @SerializedName("variantLength"   ) var variantLength   : String?                    = null,
    @SerializedName("variantDesc"     ) var variantDesc     : String?                    = null,
    @SerializedName("variantCategory" ) var variantCategory : ArrayList<VariantCategory> = arrayListOf(),
    @SerializedName("variantIsActive" ) var variantIsActive : Boolean?                   = null,
    @SerializedName("variantIsMain"   ) var variantIsMain   : Boolean?                   = null
)
