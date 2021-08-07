package io.arunbuilds.pokedex.util

sealed class Resource<Type>(val data: Type? = null, val message: String? = null) {
    class Success<Type>(data: Type) : Resource<Type>(data)
    class Error<Type>(message: String, data: Type? = null) : Resource<Type>(data, message)
    //class Loading<Type>(data: Type? = null, message: String) : Resource<Type>(data, message)
}