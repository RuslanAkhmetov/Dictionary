package ru.geekbrain.android.dictionary.repositories

import io.reactivex.Observable
import ru.geekbrain.android.dictionary.model.MainActivityContract
import ru.geekbrain.android.dictionary.model.datasource.RetrofitProvider
import ru.geekbrain.android.dictionary.model.entity.Person

class RetrofitPersonRepo : MainActivityContract.DataSource<Person> {

    val retrofitProvider = RetrofitProvider()

  /*  override fun getListPersons(): Observable<List<Person>> {
        TODO("Not yet implemented")
    }*/

    override fun getPerson(): Observable<Person> =
        retrofitProvider.getPerson()



}