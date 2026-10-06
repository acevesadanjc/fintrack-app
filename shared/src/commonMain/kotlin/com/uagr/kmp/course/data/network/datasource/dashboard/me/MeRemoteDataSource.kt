/*
 * AccountsRemoteDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.dashboard.me

import com.uagr.kmp.course.data.network.model.request.dashboard.accounts.AccountsRequest
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel
import com.uagr.kmp.course.domain.model.dashboard.me.MeModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface MeRemoteDataSource {

    suspend fun getMe(): NetworkResult<MeModel>
}
