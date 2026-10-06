/*
 * MeRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.dashboard.me

import com.uagr.kmp.course.domain.model.dashboard.me.MeModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow


interface MeRepository {
    fun getMe(): Flow<NetworkResult<MeModel>>
}