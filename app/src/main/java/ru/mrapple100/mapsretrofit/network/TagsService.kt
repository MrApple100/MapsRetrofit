package ru.mrapple100.mapsretrofit.network

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.mrapple100.mapsretrofit.model.Tags


interface TagsService {

    @GET("/api/tags")
    suspend fun getTags(): List<Tags>
    @POST("/api/tags")
    suspend fun createTags(@Body tags: Tags): Unit


}