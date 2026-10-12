package com.uagr.kmp.course.data.network.model.response.transactions.transactions

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class TransactionsResponse(
    val items: List<Item>?,
    val pagination: Pagination?
): BaseResponse()