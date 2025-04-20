package com.quare

import software.quare.data_status.DataStatus
import software.quare.data_status.getLoadingData
import java.util.UUID

fun main() {
    val userLoadedPhoto = User(
        id = UUID.randomUUID().toString(),
        photo = DataStatus.Loaded("https://photo.png"),
        name =  "John Doe",
        email = "john.doe@example.com",
    )
    println(userLoadedPhoto)
    userLoadedPhoto.copy(photo = getLoadingData())
    println(userLoadedPhoto)
}
