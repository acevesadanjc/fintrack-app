package com.uagr.kmp.course.data.local.model.user

import androidx.room3.Entity
import androidx.room3.PrimaryKey

/**
 * uuid: Identificador único universal del usuario. Se retorna en la respuesta de autenticación y se usa para asociar cuentas financieras, transacciones y dispositivos.
 * email: Correo electrónico del usuario. Debe ser único e indexado para acelerar la validación al iniciar sesión.
 * full_name: Nombre completo para mostrar en la interfaz y en el endpoint /me.
 * created_at Fecha y hora de creación de la cuenta (ej. 2026-10-04T18:30:00Z).
 * updated_at: Control de auditoría para saber cuándo se actualizaron los datos del usuario por última vez.
 * isLoggedIn: Estado de sesión.
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val uuid: String?,
    val email: String?,
    val fullName: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val isLoggedIn: Boolean?
)
