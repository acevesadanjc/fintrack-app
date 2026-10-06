
/*
 * MeUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.dashboard.me

import com.uagr.kmp.course.domain.model.dashboard.me.MeModel
import com.uagr.kmp.course.domain.repository.dashboard.me.MeRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

/**
 *
 */
@Factory
class MeUseCase(
    private val repository: MeRepository,
) {

    fun getMe(): Flow<NetworkResult<MeModel>> = repository.getMe()
}