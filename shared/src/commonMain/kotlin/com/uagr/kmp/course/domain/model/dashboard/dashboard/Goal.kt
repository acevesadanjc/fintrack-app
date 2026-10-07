/*
 * Goal.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.dashboard

data class Goal(
    val id: String,
    val name: String,
    val targetAmount: String,
    val currentAmount: String,
    val targetDate: String,
    val status: String,
    val createdAt: String,
    val updatedAt: String,
    val version: Int
)