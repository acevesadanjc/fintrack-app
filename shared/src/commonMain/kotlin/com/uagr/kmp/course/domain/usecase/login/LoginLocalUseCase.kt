/*
 * LoginLocalUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login

import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.model.login.LoginModel
import com.uagr.kmp.course.domain.model.user.UserModel
import com.uagr.kmp.course.domain.repository.login.LoginRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Factory

/**
 *
 */
@Factory
class LoginLocalUseCase(
    private val repository: LoginRepository,
) {

    fun saveAccessToken(
        accessToken: String
    ): Flow<Unit> = repository.saveAccessToken(accessToken = accessToken)


    fun deleteAndInsertUser(
        user: UserModel
    ): Flow<Unit> = repository.deleteAndInsertUser(user = user)
}
