package com.dev.trendrepo.data.remote

import com.dev.trendrepo.data.model.GetRepoModel
import retrofit2.Response
import retrofit2.http.GET

interface HandlApi {

    @GET("repositories?q=language=+sort:stars")
    suspend fun getCategoryList(): Response<GetRepoModel>
}