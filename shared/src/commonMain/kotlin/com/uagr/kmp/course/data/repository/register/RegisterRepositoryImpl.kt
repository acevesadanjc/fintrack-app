/*
 * RegisterRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.register


import com.uagr.kmp.course.data.network.datasource.register.RegisterRemoteDataSource
import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.domain.model.register.RegisterModel
import com.uagr.kmp.course.domain.repository.register.RegisterRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

/**
 * Ejecuta la lógica: orquesta los DataSources (red, base de datos local), maneja las respuestas HTTP,
 * aplica la caché y convierte los DTOs (Response) a modelos de dominio (Model).
 *
 * Regla: Implementa la interfaz de dominio y depende de la capa de datos (DataSources, DTOs, Mappers).
 *
 * El mapeo se hace dentro de la implementación del (RepositoryImpl) en la capa de data, transformando el Flow
 * de respuestas DTO antes de exponerlo a las capas superiores.
 *
 * Nota: Colocar la interfaz en domain y la implementación en data evita que la capa de Dominio tenga que importar
 * o depender de la capa de Datos. Así, si mañana cambias Ktor por otra librería, la capa de dominio ni se entera.
 *
 * Nota: La función flow construye una secuencia fría; crear el Flow no es una operación suspensiva.
 * La suspensión ocurre recién cuando alguien llama a .collect().
 *
 */
@Factory
class RegisterRepositoryImpl(
    private val dataSource: RegisterRemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : RegisterRepository {

    override fun registerUser(
        request: RegisterRequest,
    ): Flow<NetworkResult<RegisterModel>> = flow {
        emit(
            dataSource.registerUser( request = request)
        )
    }.flowOn(context = dispatcher)
}