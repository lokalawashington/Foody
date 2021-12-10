package com.ifixhubke.foody.models

import android.os.Parcel
import android.os.Parcelable

data class HotelModels(
    val hotelId: Int=0,
    val hotelImage: String?= "",
    val hotelName: String?= "",
    val hotelMenu: MenuItems? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        TODO("hotelMenu")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(hotelId)
        parcel.writeString(hotelImage)
        parcel.writeString(hotelName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HotelModels> {
        override fun createFromParcel(parcel: Parcel): HotelModels {
            return HotelModels(parcel)
        }

        override fun newArray(size: Int): Array<HotelModels?> {
            return arrayOfNulls(size)
        }
    }
}
