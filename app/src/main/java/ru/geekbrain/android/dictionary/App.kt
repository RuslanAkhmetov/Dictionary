package ru.geekbrain.android.dictionary

import android.app.Application
import ru.geekbrain.android.dictionary.model.MainActivityContract
import ru.geekbrain.android.dictionary.model.entity.Person
import ru.geekbrain.android.dictionary.repositories.RetrofitPersonRepo

class App: Application() {

    val repository: MainActivityContract.DataSource<Person> by lazy { RetrofitPersonRepo() }


    companion object{
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}