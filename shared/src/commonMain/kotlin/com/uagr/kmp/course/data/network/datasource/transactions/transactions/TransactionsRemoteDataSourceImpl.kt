/*
 * TransactionsRemoteDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.transactions.transactions

import com.uagr.kmp.course.data.network.model.response.transactions.transactions.TransactionsResponse
import com.uagr.kmp.course.domain.mapper.transactions.transactions.toDomain
import com.uagr.kmp.course.domain.model.transactions.TransactionsModel
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory


@Factory
class TransactionsRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : TransactionsRemoteDataSource {

    override suspend fun getTransactions(): NetworkResult<TransactionsModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = NetworkUrl.GET_TRANSACTIONS_ENDPOINT) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data: TransactionsResponse ->
                data.toDomain()
            },
        )
}