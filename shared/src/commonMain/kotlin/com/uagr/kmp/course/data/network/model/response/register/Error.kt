/*
 * Error.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import kotlinx.serialization.Serializable

@Serializable
data class Error(
    val code: String?,
    val details: List<Detail>?,
    val message: String?,
    val request_id: String?
)