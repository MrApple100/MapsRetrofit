package ru.mrapple100.mapsretrofit

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mrapple100.mapsretrofit.model.Tags
import ru.mrapple100.mapsretrofit.network.Resource
import javax.inject.Inject

@HiltViewModel
class TagsViewModel @Inject constructor(
   val tagsRepository: TagsRepository
):ViewModel() {


    val tagsMutableStateFlow = MutableStateFlow<List<Tags>?>(null)
    val _tagsStateFlow = tagsMutableStateFlow.asStateFlow()


    fun fetchTags() = GlobalScope.launch {
        var resource: Resource<List<Tags>> = Resource.Loading
        tagsRepository.fetchTags().handle(
            onSuccess = {
                Log.d("VIEWMODELVIEW",it.toString())
                tagsMutableStateFlow.value = it
                resource = Resource.Success(it)
            }
        )
        resource
    }

    fun createTag(lat:Float,long:Float,des:String) = GlobalScope.launch {
        tagsRepository.createTag(Tags("0",lat,long,des,null,0,false))
    }
}