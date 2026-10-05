/*
 * RegisterRequest.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.request.register


import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val email: String,
    val name: String,
    val password: String
)