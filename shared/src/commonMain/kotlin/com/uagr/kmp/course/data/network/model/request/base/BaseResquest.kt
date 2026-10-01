/*
 * BaseResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.request.base

import kotlinx.serialization.Serializable

@Serializable
open class BaseResquest(
    val success: Boolean? = false,
    val message: String? = "",
)
