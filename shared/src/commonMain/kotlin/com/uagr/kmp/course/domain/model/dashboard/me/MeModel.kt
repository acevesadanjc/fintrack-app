/*
 * MeModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.me


data class MeModel(
    val id: String,
    val name: String,
    val email: String,
    val currency: String,
    val timezone: String,
    val locale: String,
    val isActive: Boolean,
    val emailVerified: Boolean
)