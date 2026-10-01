/*
 * LoginRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.login

import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.data.network.model.response.login.LoginResponse
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory


@Factory
class LoginRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : LoginRemoteDataSource {

    override suspend fun login(
        request: LoginRequest,
    ): NetworkResult<LoginResponse> =
        safeApiCall(
            apiCall = {
                httpClient.post(urlString = NetworkUrl.LOGIN_ENDPOINT) {
                    contentType(type = ContentType.Application.Json)
                    setBody(body = request)
                }
            }
        )
}