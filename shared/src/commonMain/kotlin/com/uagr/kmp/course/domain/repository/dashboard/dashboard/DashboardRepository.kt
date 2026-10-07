/*
 * DashboardRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.dashboard.dashboard

import com.uagr.kmp.course.domain.model.dashboard.dashboard.DashboardModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow


interface DashboardRepository {
    fun dashboard(): Flow<NetworkResult<DashboardModel>>
}