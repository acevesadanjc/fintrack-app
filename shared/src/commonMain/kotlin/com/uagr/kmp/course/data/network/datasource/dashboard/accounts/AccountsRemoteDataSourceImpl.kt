/*
 * AccountsRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.dashboard.accounts

import com.uagr.kmp.course.data.network.model.request.dashboard.accounts.AccountsRequest
import com.uagr.kmp.course.data.network.model.response.dashboard.accounts.AccountsResponse
import com.uagr.kmp.course.data.network.model.response.dashboard.getaccounts.GetAccountsResponse
import com.uagr.kmp.course.domain.mapper.dashboard.accounts.toDomain
import com.uagr.kmp.course.domain.mapper.dashboard.getaccounts.toDomain
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel
import com.uagr.kmp.course.domain.model.dashboard.getaccounts.GetAccountsModel
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class AccountsRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : AccountsRemoteDataSource {

    override suspend fun accounts(
        request: AccountsRequest,
    ): NetworkResult<AccountsModel> =
        safeApiCall(
            apiCall = {
                httpClient.post(urlString = NetworkUrl.ACCOUNTS_ENDPOINT) {
                    contentType(type = ContentType.Application.Json)
                    setBody(body = request)
                }
            },
            transform = { data: AccountsResponse ->
                data.toDomain()
            },
        )

    override suspend fun getAccounts(): NetworkResult<GetAccountsModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = NetworkUrl.GET_ACCOUNTS_ENDPOINT) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data: GetAccountsResponse ->
                data.toDomain()
            }
        )
}