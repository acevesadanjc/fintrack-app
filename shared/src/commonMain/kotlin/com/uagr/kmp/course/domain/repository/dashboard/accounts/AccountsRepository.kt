/*
 * AccountsRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.dashboard.accounts

import com.uagr.kmp.course.data.network.model.request.dashboard.accounts.AccountsRequest
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow


interface AccountsRepository {
    fun accounts(
        request: AccountsRequest,
    ): Flow<NetworkResult<AccountsModel>>
}