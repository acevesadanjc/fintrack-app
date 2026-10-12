/*
 * TransactionsRemoteDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.transactions.transactions

import com.uagr.kmp.course.domain.model.transactions.TransactionsModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface TransactionsRemoteDataSource {

    suspend fun getTransactions(): NetworkResult<TransactionsModel>
}
