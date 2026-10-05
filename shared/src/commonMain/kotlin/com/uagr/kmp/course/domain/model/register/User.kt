/*
 * User.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.register


data class User(
    val currency: String,
    val email: String,
    val emailVerified: Boolean,
    val id: String,
    val isActive: Boolean,
    val locale: String,
    val name: String
)