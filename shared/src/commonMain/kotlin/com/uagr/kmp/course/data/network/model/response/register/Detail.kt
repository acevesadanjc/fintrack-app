/*
 * Detail.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Detail(
    @SerialName("loc")
    val loc: List<String>,
    @SerialName("message")
    val message: String,
    @SerialName("type")
    val type: String
)