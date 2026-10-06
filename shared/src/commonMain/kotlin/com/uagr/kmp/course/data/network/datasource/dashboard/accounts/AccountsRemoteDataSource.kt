package com.uagr.kmp.course.data.network.datasource.dashboard.accounts

import com.uagr.kmp.course.data.network.model.request.dashboard.accounts.AccountsRequest
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface AccountsRemoteDataSource {

    suspend fun accounts(
        request: AccountsRequest,
    ): NetworkResult<AccountsModel>
}