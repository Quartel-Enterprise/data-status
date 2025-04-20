package com.quare

import software.quare.data_status.DataStatus

internal data class User(
    val id: String,
    val photo: DataStatus<String?>,
    val name: String,
    val email: String?,
)
