package ru.geekbrain.android.dictionary.model

import io.reactivex.Observable
import ru.geekbrain.android.dictionary.model.entity.Person

class MainActivityContract {

    interface MainView {
        fun showPerson(person: String)
        fun showLoadingProcess()
        fun showError(error: String)
    }

    interface Presenter{
        fun onAttach()
        fun onDetach()
        fun getPerson()
    }

    interface DataSource<T> {
       // fun getListPersons() : Observable<List<T>>
        fun getPerson(): Observable< T>
    }

}
