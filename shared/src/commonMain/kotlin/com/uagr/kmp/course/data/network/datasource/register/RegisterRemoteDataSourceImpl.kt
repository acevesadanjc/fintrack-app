/*
 * RegisterRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.register

import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.data.network.model.response.register.RegisterResponse
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

/**
 * Principio de Separación de Responsabilidades en Clean Architecture.
 * Cada capa tiene una función clara y no debe asumir tareas que no le corresponden:
 *
 *  El trabajo del DataSource es únicamente comunicarse con el medio externo (API REST, Firebase, Room, etc.)
 *  y devolver el dato exactamente como viene de la fuente.
 *
 *  El Repository es el que realiza la transformación.
 *  El Repository actúa como un mediador y orquestador entre las fuentes de datos y la lógica de negocio.
 *  Es quien convierte el DTO (Response) al modelo de dominio (Model).
 *
 */
@Factory
class RegisterRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : RegisterRemoteDataSource {

    override suspend fun registerUser(
        request: RegisterRequest,
    ): NetworkResult<RegisterResponse> =
        safeApiCall(
            apiCall = {
                httpClient.post(urlString = NetworkUrl.REGISTER_ENDPOINT) {
                    contentType(type = ContentType.Application.Json)
                    setBody(body = request)
                }
            }
        )
}