/*
 * TransactionsRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.transactions

import com.uagr.kmp.course.domain.model.transactions.TransactionsModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow


interface TransactionsRepository {
    fun getTransactions(): Flow<NetworkResult<TransactionsModel>>
}