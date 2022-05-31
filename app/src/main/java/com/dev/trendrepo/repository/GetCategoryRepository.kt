package com.dev.trendrepo.repository

import com.dev.trendrepo.data.model.GetRepoModel
import com.dev.trendrepo.data.remote.HandlApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetCategoryRepository @Inject constructor(
    private val handlApi: HandlApi
) {
    suspend fun getCategoryList(): Response<GetRepoModel> {
        return handlApi.getCategoryList()
    }
}