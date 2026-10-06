/*
 * UserModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.user

data class UserModel(
    val uuid: String?,
    val email: String?,
    val fullName: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val isLoggedIn: Boolean?
)



