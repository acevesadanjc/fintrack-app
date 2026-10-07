/*
 * DashboardRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.dashboard.dashboard

import com.uagr.kmp.course.data.network.datasource.dashboard.dashboard.DashboardRemoteDataSource
import com.uagr.kmp.course.domain.model.dashboard.dashboard.DashboardModel
import com.uagr.kmp.course.domain.repository.dashboard.dashboard.DashboardRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory


@Factory
class DashboardRepositoryImpl(
    private val dataSource: DashboardRemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : DashboardRepository {

    override fun dashboard(): Flow<NetworkResult<DashboardModel>> = flow {
        emit(value = dataSource.dashboard())
    }.flowOn(context = dispatcher)

}