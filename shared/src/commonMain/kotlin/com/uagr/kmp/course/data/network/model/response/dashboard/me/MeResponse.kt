package com.uagr.kmp.course.data.network.model.response.dashboard.me

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable


@Serializable
data class MeResponse(
    val id: String,
    val name: String,
    val email: String,
    val currency: String,
    val timezone: String,
    val locale: String,
    val is_active: Boolean,
    val email_verified: Boolean,
    val created_at: String,
    val updated_at: String,
) : BaseResponse()