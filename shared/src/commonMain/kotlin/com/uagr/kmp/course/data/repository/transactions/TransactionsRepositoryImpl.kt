/*
 * TransactionsRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.transactions

import com.uagr.kmp.course.data.network.datasource.transactions.transactions.TransactionsRemoteDataSource
import com.uagr.kmp.course.domain.model.transactions.TransactionsModel
import com.uagr.kmp.course.domain.repository.transactions.TransactionsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory


@Factory
class TransactionsRepositoryImpl(
    private val dataSource: TransactionsRemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : TransactionsRepository {

    override fun getTransactions(): Flow<NetworkResult<TransactionsModel>> = flow {
        emit(dataSource.getTransactions())
    }.flowOn(context = dispatcher)

}