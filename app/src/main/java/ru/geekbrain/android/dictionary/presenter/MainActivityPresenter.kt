package ru.geekbrain.android.dictionary.presenter

import geekbrains.ru.translator.rx.SchedulerProvider
import ru.geekbrain.android.dictionary.App
import ru.geekbrain.android.dictionary.model.MainActivityContract
import ru.geekbrain.android.dictionary.model.entity.Person
import java.util.*


class MainActivityPresenter(private var activity: MainActivityContract.MainView?) :
    MainActivityContract.Presenter {

    lateinit var repository: MainActivityContract.DataSource<Person>


    override fun onAttach() {
        repository = App.instance.repository

    }

    override fun onDetach() {
        activity = null
    }

    override fun getPerson() {
        repository.getPerson()
            .subscribeOn(SchedulerProvider().io())
            .observeOn(SchedulerProvider().ui())
            .subscribe({person->

                activity?.showPerson(person.results[0].name.first + " " + person.results[0].name.last)
            },{
                activity?.showError(it.message.toString())
            },
            )


    }

}