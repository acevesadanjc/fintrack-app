package com.uagr.kmp.course.data.repository.dashboard.accounts

import com.uagr.kmp.course.data.network.datasource.dashboard.AccountsRemoteDataSource
import com.uagr.kmp.course.data.network.model.request.dashboard.accounts.AccountsRequest
import com.uagr.kmp.course.domain.mapper.dashboard.accounts.toDomain
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel
import com.uagr.kmp.course.domain.repository.dashboard.accounts.AccountsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory


@Factory
class AccountsRepositoryImpl(
    private val dataSource: AccountsRemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : AccountsRepository {

    override fun accounts(
        request: AccountsRequest
    ): Flow<NetworkResult<AccountsModel>> = flow {
        val result = dataSource.accounts(request)
        val domainResult = when (result) {
            is NetworkResult.Success -> NetworkResult.Success(result.response.toDomain())
            is NetworkResult.Error -> result
        }
        emit(value = domainResult)
    }.flowOn(context = dispatcher)

}