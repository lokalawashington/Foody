package com.ifixhubke.foody.models

import android.os.Parcel
import android.os.Parcelable

data class Order(
    val numberOfOrders: Int?,
    val tableNumber: String?,
    val orderAmount: Int?,
    val foodName: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(numberOfOrders)
        parcel.writeString(tableNumber)
        parcel.writeValue(orderAmount)
        parcel.writeString(foodName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Order> {
        override fun createFromParcel(parcel: Parcel): Order {
            return Order(parcel)
        }

        override fun newArray(size: Int): Array<Order?> {
            return arrayOfNulls(size)
        }
    }
}
