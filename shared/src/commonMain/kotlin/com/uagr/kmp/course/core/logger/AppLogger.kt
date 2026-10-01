package com.uagr.kmp.course.core.logger


/**
 * Provides a platform-independent logging abstraction for the application.
 *
 *
 * This interface allows shared KMP code to log messages without depending
 * directly on a platform-specific logging implementation. The underlying
 * implementation can delegate logging to libraries such as Napier and
 * provide platform-specific behavior for Android and iOS.
 *
 *
 * Implementations should preserve the log level and optional tag when
 * forwarding messages to the underlying logging framework.
 *
 */
interface AppLogger {

    fun debug(
        message: String,
        tag: String? = null
    )

    fun info(
        message: String,
        tag: String? = null
    )

    fun warning(
        message: String,
        tag: String? = null
    )

    fun error(
        throwable: Throwable? = null,
        message: String,
        tag: String? = null
    )
}