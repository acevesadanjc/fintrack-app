/*
 * DashboardUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.dashboard.dashboard

import com.uagr.kmp.course.domain.model.dashboard.dashboard.DashboardModel
import com.uagr.kmp.course.domain.repository.dashboard.dashboard.DashboardRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

/**
 *
 */
@Factory
class DashboardUseCase(
    private val repository: DashboardRepository,
) {
    fun dashboard(): Flow<NetworkResult<DashboardModel>> = repository.dashboard()
}