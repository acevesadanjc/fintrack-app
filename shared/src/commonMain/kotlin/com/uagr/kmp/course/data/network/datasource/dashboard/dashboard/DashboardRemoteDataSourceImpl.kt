/*
 * DashboardRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.dashboard.dashboard

import com.uagr.kmp.course.data.network.model.response.dashboard.dashboard.DashboardResponse
import com.uagr.kmp.course.domain.mapper.dashboard.dashboard.toDomain
import com.uagr.kmp.course.domain.model.dashboard.dashboard.DashboardModel
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class DashboardRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : DashboardRemoteDataSource {

    override suspend fun dashboard(): NetworkResult<DashboardModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = NetworkUrl.DASHBOARD_ENDPOINT) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data: DashboardResponse ->
                data.toDomain()
            },
        )
}