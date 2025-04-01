package ru.mrapple100.mapsretrofit.model

import com.google.gson.annotations.Expose

data class Tags(
    //@SerializedName("id")
    @Expose
    val id:String,
   // @SerializedName("latitude")
    @Expose
    val latitude:Float,
    @Expose
    val longitude:Float,
    @Expose
    val description:String,
    @Expose
    val image: String?,
    @Expose
    val likes: Int,
    @Expose
    val is_liked: Boolean
)