/*
 * User.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import kotlinx.serialization.Serializable

@Serializable
data class User(
    val created_at: String?,
    val currency: String?,
    val email: String?,
    val email_verified: Boolean?,
    val id: String?,
    val is_active: Boolean?,
    val locale: String?,
    val name: String?,
    val timezone: String?,
    val updated_at: String?
)