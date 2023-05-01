package id.co.orderfaz.feature.rate.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CodFee (

    @SerializedName("percentage" ) var percentage : Int? = null,
    @SerializedName("amount"     ) var amount     : Int? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(percentage)
        parcel.writeValue(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CodFee> {
        override fun createFromParcel(parcel: Parcel): CodFee {
            return CodFee(parcel)
        }

        override fun newArray(size: Int): Array<CodFee?> {
            return arrayOfNulls(size)
        }
    }
}