/*
 * BaseResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.base

import kotlinx.serialization.Serializable

// Siempre se asigna = null a los campos opcionales en tus Data Classes cuando mapees JSONs de red
@Serializable
open class BaseResponse(
    val success: Boolean? = null,
    val message: String? = null,
    val error: ErrorPayload? = null
) {
    /**
     * Retorna true si la respuesta no trae objeto 'error' y 'success' no es false.
     */
    val isSuccessful: Boolean
        get() = error == null && success != false

}
