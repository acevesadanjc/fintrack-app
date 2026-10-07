/*
 * NetworkUrl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.utils.constant

object NetworkUrl {

    // Base url
    const val BASE_URL = "https://fintrack-hitss.onrender.com"

    // Endpoint
    // POST
    const val LOGIN_ENDPOINT = "/api/v1/auth/login"
    // POST
    const val REGISTER_ENDPOINT = "/api/v1/auth/register"
    // GET Obtener la información del usuario autenticado, incluyendo su perfil y detalles personales.
    const val ME_ENDPOINT = "/api/v1/users/me"
    // Crear/enlazar cuenta bancaria a un usuario.
    const val ACCOUNTS_ENDPOINT = "/api/v1/accounts"
    // Obtener datos de cuentas de usuario.
    const val GET_ACCOUNTS_ENDPOINT = "/api/v1/accounts"

    // Obtener la vista de la situación financiera del usuario.
    const val DASHBOARD_ENDPOINT = "/api/v1/dashboard"

    /*
    Resumen financiero: GET /api/v1/analytics/summary.
    Flujo de efectivo: GET /api/v1/analytics/cash-flow.
    Gastos por categoría: GET /api/v1/analytics/categories.
    Saldos por cuenta: GET /api/v1/accounts.
    Últimas transacciones: GET /api/v1/transactions.
    Estado de presupuestos: GET /api/v1/budgets/summary.
*/

    // Enfoque Offline-First en el cliente (KMP)
    //La información se actualiza en segundo plano mediante el servicio POST /api/v1/sync cuando el dispositivo recupera la conectividad.
    const val SYNC_ENDPOINT = "/api/v1/sync"
}
