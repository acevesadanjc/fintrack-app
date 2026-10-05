/*
 * Detail.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.register


import kotlinx.serialization.Serializable

@Serializable
data class Detail(
    val loc: List<String>,
    val message: String,
    val type: String
)