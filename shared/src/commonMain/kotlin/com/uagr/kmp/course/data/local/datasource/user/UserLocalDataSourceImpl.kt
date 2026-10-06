/*
 * UserLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.user

import com.uagr.kmp.course.data.local.database.dao.user.UserDao
import com.uagr.kmp.course.data.local.datastore.AppDataStore
import com.uagr.kmp.course.domain.mapper.user.toDomain
import com.uagr.kmp.course.domain.mapper.user.toEntity
import com.uagr.kmp.course.domain.model.user.UserModel
import org.koin.core.annotation.Factory

@Factory
class UserLocalDataSourceImpl(
    private val userDao: UserDao,
    private val appDataStore: AppDataStore
): UserLocalDataSource {

    override suspend fun getUser(): UserModel {
       return userDao.getUser().toDomain()
    }

    override suspend fun deleteAndInsertUser(user: UserModel) {
        userDao.deleteAndInsertUser(user = user.toEntity())
    }

    override suspend fun saveUserAccessToken(accessToken: String) {
        appDataStore.saveUserToken(token = accessToken)
    }
}