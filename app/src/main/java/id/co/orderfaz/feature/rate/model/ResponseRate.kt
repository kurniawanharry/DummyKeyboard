package id.co.orderfaz.feature.rate.model

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ResponseRate (

    @SerializedName("logisticName"    ) var logisticName    : String?                    = null,
    @SerializedName("logisticLogoUrl" ) var logisticLogoUrl : String?                    = null,
    @SerializedName("weight"          ) var weight          : Int?                       = null,
    @SerializedName("volumeWeight"    ) var volumeWeight    : Int?                       = null,
    @SerializedName("LogisticRank"    ) var LogisticRank    : Int?                       = null,
    @SerializedName("logisticDetails" ) var logisticDetails : ArrayList<LogisticDetails> = arrayListOf()

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createTypedArrayList(LogisticDetails.CREATOR)?:ArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(logisticName)
        parcel.writeString(logisticLogoUrl)
        parcel.writeValue(weight)
        parcel.writeValue(volumeWeight)
        parcel.writeValue(LogisticRank)
        parcel.writeTypedList(logisticDetails)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResponseRate> {
        override fun createFromParcel(parcel: Parcel): ResponseRate {
            return ResponseRate(parcel)
        }

        override fun newArray(size: Int): Array<ResponseRate?> {
            return arrayOfNulls(size)
        }
    }

}