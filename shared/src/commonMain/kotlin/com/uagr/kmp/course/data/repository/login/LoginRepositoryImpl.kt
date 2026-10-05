/*
 * LoginRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.login


import com.uagr.kmp.course.data.network.datasource.login.LoginRemoteDataSource
import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.mapper.login.toDomain
import com.uagr.kmp.course.domain.model.login.LoginModel
import com.uagr.kmp.course.domain.repository.login.LoginRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory


@Factory
class LoginRepositoryImpl(
    private val dataSource: LoginRemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : LoginRepository {

    override fun login(
        request: LoginRequest,
    ): Flow<NetworkResult<LoginModel>> = flow {
        emit(
            dataSource.login( request = request)
        )
    }.flowOn(context = dispatcher)
}