/*
 * LoginRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.login


import com.uagr.kmp.course.data.local.datasource.user.UserLocalDataSource
import com.uagr.kmp.course.data.local.model.user.UserEntity
import com.uagr.kmp.course.data.network.datasource.login.LoginRemoteDataSource
import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.model.login.LoginModel
import com.uagr.kmp.course.domain.model.user.UserModel
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
    private val localDataSource: UserLocalDataSource,
    private val dispatcher: CoroutineDispatcher,
) : LoginRepository {

    override fun login(
        request: LoginRequest,
    ): Flow<NetworkResult<LoginModel>> = flow {
        emit(dataSource.login( request = request))
    }.flowOn(context = dispatcher)

    override fun deleteAndInsertUser(user: UserModel) : Flow<Unit> = flow {
        emit(localDataSource.deleteAndInsertUser(user = user))
    }.flowOn(context = dispatcher)

    override fun saveAccessToken(accessToken: String): Flow<Unit> = flow {
        emit(localDataSource.saveUserAccessToken(accessToken = accessToken))
    }.flowOn(context = dispatcher)
}