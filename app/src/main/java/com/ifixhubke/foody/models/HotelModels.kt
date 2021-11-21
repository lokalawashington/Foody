package com.ifixhubke.foody.models

data class HotelModels(
    val hotelId: Int=0,
    val hotelImage: String?= "",
    val hotelName: String?= "",
    val hotelMenu: MenuItems? = null
)
