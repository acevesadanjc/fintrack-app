/*
 * DashboardRemoteDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.dashboard.dashboard

import com.uagr.kmp.course.domain.model.dashboard.dashboard.DashboardModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface DashboardRemoteDataSource {

    suspend fun dashboard(): NetworkResult<DashboardModel>
}