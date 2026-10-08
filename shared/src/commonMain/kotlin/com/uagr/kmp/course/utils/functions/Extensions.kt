package com.uagr.kmp.course.utils.functions



fun Double.toCurrency(isDecimalAdded: Boolean): String {
    val integerPart = toLong()
    val decimalPart = ((this - integerPart) * 100).toLong()

    val formattedInteger = integerPart
        .toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
    return if (isDecimalAdded) {
        "$$formattedInteger.${decimalPart.toString().padStart(2, '0')}"
    } else {
        "$$formattedInteger"
    }
}