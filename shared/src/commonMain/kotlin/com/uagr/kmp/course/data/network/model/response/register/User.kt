/*
 * User.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("currency")
    val currency: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("email_verified")
    val emailVerified: Boolean?,
    @SerialName("id")
    val id: String?,
    @SerialName("is_active")
    val isActive: Boolean?,
    @SerialName("locale")
    val locale: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("updated_at")
    val updatedAt: String?
)