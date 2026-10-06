/*
 * MeRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.dashboard.me

import com.uagr.kmp.course.data.network.datasource.dashboard.me.MeRemoteDataSource
import com.uagr.kmp.course.domain.model.dashboard.me.MeModel
import com.uagr.kmp.course.domain.repository.dashboard.me.MeRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory


@Factory
class MeRepositoryImpl(
    private val dataSource: MeRemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : MeRepository {


    override fun getMe(): Flow<NetworkResult<MeModel>> = flow {
        emit(dataSource.getMe())
    }.flowOn(context = dispatcher)

}