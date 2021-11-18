package com.ifixhubke.foody.models

import java.lang.reflect.Array

data class HotelModels(
    val hotelId: Int,
    val hotelImage: String?,
    val hotelName: String?,
    val hotelMenu: List<MenuItems>
)
