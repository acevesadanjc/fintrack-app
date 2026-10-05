/*
 * Tokens.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import kotlinx.serialization.Serializable

@Serializable
data class Tokens(
    val access_token: String?,
    val expires_in: Int?,
    val refresh_token: String?,
    val token_type: String?
)