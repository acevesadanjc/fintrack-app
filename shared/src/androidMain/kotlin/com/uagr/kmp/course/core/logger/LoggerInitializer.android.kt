package com.uagr.kmp.course.core.logger

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

/**
 *
 * Initializes Napier using the platform-specific debug logger.
 *
 *
 * This implementation configures Napier with [DebugAntilog], allowing
 * log messages from shared KMP code to be output through the platform's
 * debugging console.
 *
 **/
actual fun initializeLogger() {
    Napier.base(DebugAntilog())
}
