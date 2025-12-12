package com.app.k1.ed.workmate_countries.core

sealed class RequestResult<T> {
    class Success<T>(val data: T) : RequestResult<T>()
    class Error<T>(val message: String) : RequestResult<T>()
}