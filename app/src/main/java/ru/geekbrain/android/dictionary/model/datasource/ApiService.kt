package ru.geekbrain.android.dictionary.model.datasource

import io.reactivex.Observable
import retrofit2.http.GET
import ru.geekbrain.android.dictionary.model.entity.Person

interface ApiService {
    @GET("api")
    fun getUser(): Observable<Person>
}