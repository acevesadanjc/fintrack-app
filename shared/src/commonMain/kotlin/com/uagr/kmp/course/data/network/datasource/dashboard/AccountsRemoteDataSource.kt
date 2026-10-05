/*
 * AccountsRemoteDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.dashboard

import com.uagr.kmp.course.data.network.model.request.dashboard.accounts.AccountsRequest
import com.uagr.kmp.course.data.network.model.response.dashboard.accounts.AccountsResponse
import com.uagr.kmp.course.utils.network.NetworkResult

interface AccountsRemoteDataSource {

    suspend fun accounts(
        request: AccountsRequest,
    ): NetworkResult<AccountsResponse>
}
