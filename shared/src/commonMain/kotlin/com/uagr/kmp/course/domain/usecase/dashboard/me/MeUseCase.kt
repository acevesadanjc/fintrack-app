
/*
 * AccountsUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.dashboard.me

import com.uagr.kmp.course.data.network.model.request.dashboard.accounts.AccountsRequest
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel
import com.uagr.kmp.course.domain.repository.dashboard.accounts.AccountsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

/**
 *
 */
@Factory
class MeUseCase(
    private val repository: AccountsRepository,
) {

    fun getMe(
        color: String,
        currency: String,
        icon: String,
        id: String,
        initialBalance: Int,
        name: String,
        type: String
    ): Flow<NetworkResult<AccountsModel>> = repository.accounts(
        request = AccountsRequest(
            color = color,
            currency = currency,
            icon = icon,
            id = id,
            initial_balance = initialBalance,
            name = name,
            type = type
        )
    )
}