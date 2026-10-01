/*
 * RegisterModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterModel(
    @SerialName("error")
    val error: Error,
    @SerialName("tokens")
    val tokens: Tokens,
    @SerialName("user")
    val user: User
)