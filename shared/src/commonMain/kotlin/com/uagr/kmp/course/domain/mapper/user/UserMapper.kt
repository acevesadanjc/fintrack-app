/*
 * UserMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.user

import com.uagr.kmp.course.data.local.model.user.UserEntity
import com.uagr.kmp.course.domain.model.user.UserModel


fun UserEntity.toDomain() = UserModel(
    uuid = uuid.orEmpty(),
    email = email.orEmpty(),
    fullName = fullName.orEmpty(),
    createdAt = createdAt.orEmpty(),
    updatedAt = updatedAt.orEmpty(),
    isLoggedIn = isLoggedIn ?: false
)

fun UserModel.toEntity() = UserEntity(
    uuid = uuid,
    email = email,
    fullName = fullName,
    createdAt = createdAt,
    updatedAt = updatedAt,
    isLoggedIn = isLoggedIn
)