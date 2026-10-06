/*
 * UserDao.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.database.dao.user

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import androidx.room3.Transaction
import com.uagr.kmp.course.data.local.model.user.UserEntity
import com.uagr.kmp.course.domain.model.user.UserModel

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: UserEntity): Long

    @Query("DELETE FROM users")
    suspend fun deleteUser()

    @Transaction
    suspend fun deleteAndInsertUser(user: UserEntity) {
        deleteUser()
        insertOrUpdateUser(user)
    }

    @Query("SELECT * FROM users LIMIT 1")
    fun getUser(): UserEntity
}