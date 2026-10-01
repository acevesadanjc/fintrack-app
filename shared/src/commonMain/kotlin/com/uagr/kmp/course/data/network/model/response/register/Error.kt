/*
 * Error.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Error(
    @SerialName("code")
    val code: String?,
    @SerialName("details")
    val details: List<Detail>?,
    @SerialName("message")
    val message: String?,
    @SerialName("request_id")
    val requestId: String?
)