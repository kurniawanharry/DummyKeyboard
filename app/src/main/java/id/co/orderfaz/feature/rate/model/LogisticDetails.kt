package id.co.orderfaz.feature.rate.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class LogisticDetails (

    @SerializedName("logisticRate"              ) var logisticRate              : String?   = null,
    @SerializedName("LogisticRateRank"          ) var LogisticRateRank          : Int?      = null,
    @SerializedName("rateName"                  ) var rateName                  : String?   = null,
    @SerializedName("rateCode"                  ) var rateCode                  : String?   = null,
    @SerializedName("RateRank"                  ) var RateRank                  : Int?      = null,
    @SerializedName("minDuration"               ) var minDuration               : Int?      = null,
    @SerializedName("maxDuration"               ) var maxDuration               : Int?      = null,
    @SerializedName("durationType"              ) var durationType              : String?   = null,
    @SerializedName("price"                     ) var price                     : Int?      = null,
    @SerializedName("insurancePrice"            ) var insurancePrice            : Int?      = null,
    @SerializedName("isAvailableForPickupToday" ) var isAvailableForPickupToday : Boolean?  = null,
    @SerializedName("signature"                 ) var signature                 : String?   = null,
    @SerializedName("cashback"                  ) var cashback                  : Cashback? = Cashback(),
    @SerializedName("discount"                  ) var discount                  : Discount? = Discount(),
    @SerializedName("adminFee"                  ) var adminFee                  : AdminFee? = AdminFee(),
    @SerializedName("codFee"                    ) var codFee                    : CodFee?   = CodFee()

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readParcelable(Cashback::class.java.classLoader),
        parcel.readParcelable(Discount::class.java.classLoader),
        parcel.readParcelable(AdminFee::class.java.classLoader),
        parcel.readParcelable(CodFee::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(logisticRate)
        parcel.writeValue(LogisticRateRank)
        parcel.writeString(rateName)
        parcel.writeString(rateCode)
        parcel.writeValue(RateRank)
        parcel.writeValue(minDuration)
        parcel.writeValue(maxDuration)
        parcel.writeString(durationType)
        parcel.writeValue(price)
        parcel.writeValue(insurancePrice)
        parcel.writeValue(isAvailableForPickupToday)
        parcel.writeString(signature)
        parcel.writeParcelable(cashback, flags)
        parcel.writeParcelable(discount, flags)
        parcel.writeParcelable(adminFee, flags)
        parcel.writeParcelable(codFee, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LogisticDetails> {
        override fun createFromParcel(parcel: Parcel): LogisticDetails {
            return LogisticDetails(parcel)
        }

        override fun newArray(size: Int): Array<LogisticDetails?> {
            return arrayOfNulls(size)
        }
    }

}