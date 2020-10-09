package com.cehdoliveira.desafiomobile2you.features.details.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cehdoliveira.desafiomobile2you.R
import com.cehdoliveira.desafiomobile2you.features.details.presenter.DetailsPresenter
import com.cehdoliveira.desafiomobile2you.features.details.presenter.DetailsPresenterToView
import com.cehdoliveira.desafiomobile2you.features.details.presenter.DetailsViewToPresenter

class DetailsActivity : AppCompatActivity(), DetailsViewToPresenter {

    private val present: DetailsPresenterToView by lazy {
        DetailsPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}