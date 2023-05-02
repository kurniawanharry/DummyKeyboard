package id.co.orderfaz.feature.product.model

import com.google.gson.annotations.SerializedName

data class Products (
    @SerializedName("id"                     ) var id                     : String?                   = null,
    @SerializedName("productName"            ) var productName            : String?                   = null,
    @SerializedName("productDescription"     ) var productDescription     : String?                   = null,
    @SerializedName("slug"                   ) var slug                   : String?                   = null,
    @SerializedName("productStatusId"        ) var productStatusId        : Int?                      = null,
    @SerializedName("productStatus"          ) var productStatus          : String?                   = null,
    @SerializedName("productTypeId"          ) var productTypeId          : Int?                      = null,
    @SerializedName("productType"            ) var productType            : String?                   = null,
    @SerializedName("productCategoryId"      ) var productCategoryId      : Int?                      = null,
    @SerializedName("productCategory"        ) var productCategory        : String?                   = null,
    @SerializedName("productCategorySlug"    ) var productCategorySlug    : String?                   = null,
    @SerializedName("productImage"           ) var productImage           : ArrayList<String>         = arrayListOf(),
    @SerializedName("productVideo"           ) var productVideo           : String?                   = null,
    @SerializedName("productBrandName"       ) var productBrandName       : String?                   = null,
    @SerializedName("productBrandLogo"       ) var productBrandLogo       : String?                   = null,
    @SerializedName("productPriceUnit"       ) var productPriceUnit       : Int?                      = null,
    @SerializedName("productPriceDiscounted" ) var productPriceDiscounted : String?                   = null,
    @SerializedName("productPriceWholesale"  ) var productPriceWholesale  : String?                   = null,
    @SerializedName("productPriceCogs"       ) var productPriceCogs       : String?                   = null,
    @SerializedName("productDiscountStart"   ) var productDiscountStart   : String?                   = null,
    @SerializedName("productDiscountEnd"     ) var productDiscountEnd     : String?                   = null,
    @SerializedName("productVariant"         ) var productVariant         : ArrayList<ProductVariant> = arrayListOf(),
    @SerializedName("productBump"            ) var productBump            : ArrayList<ProductBump>    = arrayListOf(),
    @SerializedName("isFavorite"             ) var isFavorite             : Boolean?                  = null,
    @SerializedName("isHide"                 ) var isHide                 : Boolean?                  = null,
    @SerializedName("checkoutCount"          ) var checkoutCount          : Int?                      = null,
    @SerializedName("checkoutUrl"            ) var checkoutUrl            : String?                   = null,
    @SerializedName("checkoutSettingId"      ) var checkoutSettingId      : String?                   = null,
    @SerializedName("csSettingId"            ) var csSettingId            : String?                   = null,
    @SerializedName("externalData"           ) var externalData           : ExternalData?             = ExternalData(),
    @SerializedName("createdAt"              ) var createdAt              : String?                   = null,
    @SerializedName("createdBy"              ) var createdBy              : String?                   = null
)