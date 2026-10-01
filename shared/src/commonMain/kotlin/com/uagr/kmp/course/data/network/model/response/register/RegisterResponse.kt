/*
 * RegisterResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    @SerialName("tokens")
    val tokens: Tokens?,
    @SerialName("user")
    val user: User?
): BaseResponse()