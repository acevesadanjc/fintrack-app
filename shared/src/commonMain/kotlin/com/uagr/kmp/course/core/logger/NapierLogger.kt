package com.uagr.kmp.course.core.logger

import io.github.aakira.napier.Napier
import org.koin.core.annotation.Single

/**
 * [AppLogger] implementation backed by the Napier logging framework.
 *
 *
 * This class encapsulates Napier-specific logging details, allowing the rest
 * of the application to depend on the platform-independent [AppLogger]
 * abstraction instead of directly depending on Napier.
 *
 *
 * Napier provides platform-specific logging behavior for supported KMP
 *
 * targets, such as Logcat on Android and the console on iOS.
 *
 **/
@Single
class NapierLogger : AppLogger {

    override fun debug(
        message: String,
        tag: String?
    ) {
        Napier.d(
            message = message,
            tag = tag
        )
    }

    override fun info(
        message: String,
        tag: String?
    ) {
        Napier.i(
            message = message,
            tag = tag
        )
    }

    override fun warning(
        message: String,
        tag: String?
    ) {
        Napier.w(
            message = message,
            tag = tag
        )
    }

    override fun error(
        throwable: Throwable?,
        message: String,
        tag: String?
    ) {
        Napier.e(
            throwable = throwable,
            tag = tag
        ) {
            message
        }
    }
}