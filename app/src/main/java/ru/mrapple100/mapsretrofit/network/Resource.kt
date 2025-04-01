package ru.mrapple100.mapsretrofit.network

sealed class Resource<out T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error(val msg: String) : Resource<Nothing>()
    object Loading: Resource<Nothing>()

    inline fun handle(
        onSuccess: (data: T) -> Unit = {},
        onError: (msg: String) -> Unit = {},
        onLoading: () -> Unit = {},
    ) {
        when(this) {
            is Success -> onSuccess(data)
            is Error -> onError(msg)
            Loading -> onLoading()
        }
    }
}