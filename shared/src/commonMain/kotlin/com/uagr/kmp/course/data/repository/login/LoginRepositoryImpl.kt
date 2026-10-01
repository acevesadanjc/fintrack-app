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
        val result = dataSource.login(request)

        // Transforma el response al DTO Modelo de Dominio
        val domainResult = when (result) {
            is NetworkResult.Success -> NetworkResult.Success(result.response.toDomain())
            is NetworkResult.Error -> result
        }
        emit(value = domainResult)
    }.flowOn(context = dispatcher)
}