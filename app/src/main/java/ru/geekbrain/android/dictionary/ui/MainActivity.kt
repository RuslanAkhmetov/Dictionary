package ru.geekbrain.android.dictionary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.geekbrain.android.dictionary.databinding.ActivityMainBinding
import ru.geekbrain.android.dictionary.model.MainActivityContract
import ru.geekbrain.android.dictionary.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityContract.MainView {

    var binding: ActivityMainBinding? = null

    lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        presenter = MainActivityPresenter(this)
        presenter.onAttach()
        setContentView(binding!!.root)
        binding?.progressCircular?.visibility = View.GONE
        binding?.getPersonButton?.setOnClickListener {
            presenter.getPerson()
        }
    }

    override fun showPerson(person: String) {
        binding?.progressCircular?.visibility = View.GONE
        binding?.personTextView?.text = person
    }

    override fun showLoadingProcess() {
        binding?.progressCircular?.visibility = View.VISIBLE
    }

    override fun showError(error: String) {
        binding?.progressCircular?.visibility = View.GONE
        binding?.personTextView?.text = error
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()

    }
}