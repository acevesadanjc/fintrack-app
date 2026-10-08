package com.uagr.kmp.course.domain.usecase.dashboard.dashboard

import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.functions.toCurrency
import org.koin.core.annotation.Factory

@Factory
class DashboardValidationsUseCase {

    fun toCurrency(value: String, isDecimal: Boolean) =
        value.toDoubleOrNull()?.toCurrency(isDecimal) ?: "0.00"


    fun addPositiveOrNegativeSign(value: String, type: String): String =
        if (type == Constants.DEFAULT_INCOME) {
            "+$value"
        } else {
            "-$value"
        }

    fun isIncome(type: String): Boolean = type == Constants.DEFAULT_INCOME

}