package ru.mrapple100.mapsretrofit

import ru.mrapple100.mapsretrofit.model.Tags
import ru.mrapple100.mapsretrofit.network.ResponseHandler
import ru.mrapple100.mapsretrofit.network.TagsService

class TagsRepository(
    val service: TagsService,
    val handler: ResponseHandler = ResponseHandler()
) {

    suspend fun fetchTags() = handler {
        service.getTags()
    }
    suspend fun createTag(tag: Tags){
        service.createTags(tag)
    }
}