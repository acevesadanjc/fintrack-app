/*
 * FlowUtils.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.utils.flow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest


/**
 *
 * Extiende cualquier stateFlow y lo convierte en un composable
 * Está vinculada al ciclo de vida de la Recomposición de Compose gracias a LaunchedEffect.
 * Si el Composable sale del árbol de la UI la corrutina se cancela automáticamente.
 *
 */
@Composable
fun <T> StateFlow<T>.CollectWithLifecycle(
    vararg keys: Any?,
    action: suspend (T) -> Unit,
) {
    LaunchedEffect(this, *keys) {
        this@CollectWithLifecycle.collectLatest { value ->
            action(value)
        }
    }
}
