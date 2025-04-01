package ru.mrapple100.mapsretrofit.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mrapple100.mapsretrofit.TagsRepository
import ru.mrapple100.mapsretrofit.TagsViewModel
import java.util.TimeZone
import java.util.concurrent.TimeUnit

object SingletoneRetrofit {

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(10,TimeUnit.SECONDS)
        //.addInterceptor()
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://maps.rtuitlab.dev")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    val service = retrofit.create(TagsService::class.java)


    val tagsRepository = TagsRepository(service)

    val tagsViewModel = TagsViewModel(tagsRepository)
}