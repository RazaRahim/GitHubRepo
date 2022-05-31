package com.dev.trendrepo.data.model

import com.dev.trendingrepo.data.model.Item

data class GetRepoModel(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)