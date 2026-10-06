/*
 * LoginRemoteUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login

import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.model.login.LoginModel
import com.uagr.kmp.course.domain.repository.login.LoginRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

/**
 *
 */
@Factory
class LoginRemoteUseCase(
    private val repository: LoginRepository
) {

    fun login(
        email: String,
        password: String,
    ): Flow<NetworkResult<LoginModel>> =
        repository.login(
            request = LoginRequest(
                email = email,
                password = password
            )
        )
}
