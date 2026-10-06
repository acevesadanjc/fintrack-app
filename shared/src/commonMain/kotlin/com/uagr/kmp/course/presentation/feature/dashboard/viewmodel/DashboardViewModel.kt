/*
 * DashboardViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.core.logger.AppLogger
import com.uagr.kmp.course.core.logger.NapierLogger
import com.uagr.kmp.course.data.local.datastore.AppDataStore
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.dashboard.accounts.AccountsUseCase
import com.uagr.kmp.course.domain.usecase.dashboard.me.MeUseCase
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Res
import course.shared.generated.resources.accept
import course.shared.generated.resources.error
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class DashboardViewModel(
    private val appDataStore: AppDataStore,
    private val napierLogger: NapierLogger,
    private val useCaseAccounts: AccountsUseCase,
    private val useCaseMe: MeUseCase,
): ViewModel() {

    private var _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    private val _uiEffect = Channel<DashboardUiEffect>()
    val uiEffect = _uiEffect.receiveAsFlow()

    private fun sendEffect(effect: DashboardUiEffect) {
        viewModelScope.launch {
            _uiEffect.send(effect)
        }
    }

    fun onIntent(intent: DashboardUiIntent) {
        when (intent) {
            else -> {}
        }
    }

    fun getMe() = viewModelScope.launch {
        napierLogger.info(tag = "DashboardScreen", message = "Access Token: ${appDataStore.userToken.first()}")

        useCaseMe.getMe(
            color = "#2563EB",
            currency = "MXN",
            icon = "wallet",
            id = Constants.DEVICE_ID,
            initialBalance = 1500,
            name = "Cuenta principal",
            type = "CASH"
        ).onStart {
            _uiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
        }.catch {
            _uiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    _uiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                    /*
                        GUARDAR ID:
                            account_id que es el device_id que se asocia con las cuentas creadas, se requiere para realizar cualquier movimiento
                            guardar en base de datos

                        OBTENER CATEGORIAS /api/v1/categories
                            listar categorías disponibles y obtener sus category_id

                        REGISTRAR PRIMER MOVIMIENTO /api/v1/transactions
                            Se utiliza account_id y un category_id

                        CARGAR Y VISUALIZAR DASHBOARD /api/v1/dashboard
                            Redirigir al usuario a la pantalla principal de Dashboard

                     */
                    sendEffect(DashboardUiEffect.OnAssociatedAccount)
                }
                is NetworkResult.Error -> {
                    _uiState.update { state ->
                        state.copy(
                            isLoading = StatusLoading.DISMISS_LOADING,
                            errorDialog = showErrorDialog(result.message),
                        )
                    }
                }
            }
        }
    }

    fun accounts() = viewModelScope.launch {
        useCaseAccounts.accounts(
            color = "#2563EB",
            currency = "MXN",
            icon = "wallet",
            id = Constants.DEVICE_ID,
            initialBalance = 1500,
            name = "Cuenta principal",
            type = "CASH"
        ).onStart {
            _uiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
        }.catch {
            _uiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    _uiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                    /*
                        GUARDAR ID:
                            account_id que es el device_id que se asocia con las cuentas creadas, se requiere para realizar cualquier movimiento
                            guardar en base de datos

                        OBTENER CATEGORIAS /api/v1/categories
                            listar categorías disponibles y obtener sus category_id

                        REGISTRAR PRIMER MOVIMIENTO /api/v1/transactions
                            Se utiliza account_id y un category_id

                        CARGAR Y VISUALIZAR DASHBOARD /api/v1/dashboard
                            Redirigir al usuario a la pantalla principal de Dashboard

                     */
                    sendEffect(DashboardUiEffect.OnAssociatedAccount)
                }
                is NetworkResult.Error -> {
                    _uiState.update { state ->
                        state.copy(
                            isLoading = StatusLoading.DISMISS_LOADING,
                            errorDialog = showErrorDialog(result.message),
                        )
                    }
                }
            }
        }
    }


    /*
    fun initStates() {
        _uiState.update { state ->
            state.copy(
                email = "test010@gmail.com",
                password = "Testing123*",
            )
        }
    }
    */


    /*



    private fun updateEmail(email: String) = viewModelScope.launch {
        _uiState.update { state -> state.copy(email = email) }
    }

    private fun updatePassword(password: String) = viewModelScope.launch {
        _uiState.update { state -> state.copy(password = password) }
    }

    private fun updatePasswordVisible(isPasswordVisible: Boolean) = viewModelScope.launch {
        _uiState.update { state -> state.copy(isPasswordVisible = isPasswordVisible) }
    }

    private fun validateFields() {
        viewModelScope.launch {
            val validateFields = validationsUseCase.invoke(
                password = uiState.value.password
            )
            if (validateFields.hasError) {
                _uiState.update { state ->
                    state.copy(
                        errorDialog = showErrorDialog(
                            validateFields.message.orEmpty()
                        )
                    )
                }
            } else {
                login()
            }
        }
    }



    */

    private suspend fun showErrorDialog(message: String? = null) = ErrorDialogModel(
        title = getString(resource = Res.string.error),
        message = message ?: getString(resource = Res.string.please_try_again_later),
        primaryButtonText = getString(resource = Res.string.accept)
    )

    private fun dismissDialog() = viewModelScope.launch {
        _uiState.update { state -> state.copy(errorDialog = null) }
    }

}
