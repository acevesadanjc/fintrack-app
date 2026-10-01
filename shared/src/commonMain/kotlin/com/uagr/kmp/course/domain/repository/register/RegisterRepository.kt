/*
 * RegisterRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.register

import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.data.network.model.response.register.RegisterResponse
import com.uagr.kmp.course.domain.model.register.RegisterModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

/**
 * Es el contrato que define qué operaciones de datos puede solicitar la aplicación,
 * sin importar de dónde provienen (red, base de datos local, mock, etc.).
 *
 * Regla: No conoce nada sobre Ktor, Room, DTOs ni bibliotecas externas. Solo maneja modelos de dominio (ResponseModel).
 *
 */
interface RegisterRepository {
    fun registerUser(
        request: RegisterRequest,
    ): Flow<NetworkResult<RegisterModel>>
}
