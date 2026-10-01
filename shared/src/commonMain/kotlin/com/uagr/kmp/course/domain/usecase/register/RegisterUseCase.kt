/*
 * RegisterUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.register

import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.domain.model.register.RegisterModel
import com.uagr.kmp.course.domain.repository.register.RegisterRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

/**
 *
 */
@Factory
class RegisterUseCase(
    private val repository: RegisterRepository,
) {

    fun register(
        email: String,
        name: String,
        password: String,
    ): Flow<NetworkResult<RegisterModel>> =
        repository.registerUser(
            request = RegisterRequest(
                email = email,
                name = name,
                password = password,
            ),
        )
}
