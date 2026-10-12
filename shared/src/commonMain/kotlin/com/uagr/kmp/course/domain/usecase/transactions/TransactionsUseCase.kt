/*
 * TransactionsUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.transactions

import com.uagr.kmp.course.domain.model.transactions.TransactionsModel
import com.uagr.kmp.course.domain.repository.transactions.TransactionsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class TransactionsUseCase(
    private val repository: TransactionsRepository,
) {

    fun getTransactions(): Flow<NetworkResult<TransactionsModel>> = repository.getTransactions()
}