/*
 * UserLocalDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.user

import com.uagr.kmp.course.domain.model.user.UserModel

interface UserLocalDataSource {
    suspend fun getUser(): UserModel
    suspend fun deleteAndInsertUser(user: UserModel)
    suspend fun saveUserAccessToken(accessToken: String)
}