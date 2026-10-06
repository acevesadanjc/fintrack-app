/*
 * MeRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.dashboard.me

import com.uagr.kmp.course.data.network.model.response.dashboard.me.MeResponse
import com.uagr.kmp.course.domain.mapper.dashboard.me.toDomain
import com.uagr.kmp.course.domain.model.dashboard.me.MeModel
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory


@Factory
class MeRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : MeRemoteDataSource {

    override suspend fun getMe(): NetworkResult<MeModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = NetworkUrl.ME_ENDPOINT) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data: MeResponse ->
                data.toDomain()
            },
        )
}