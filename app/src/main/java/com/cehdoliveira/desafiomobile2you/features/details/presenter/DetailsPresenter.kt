package com.cehdoliveira.desafiomobile2you.features.details.presenter

import com.cehdoliveira.desafiomobile2you.features.details.interact.DetailsInteract
import com.cehdoliveira.desafiomobile2you.features.details.interact.DetailsInteractToPresenter
import com.cehdoliveira.desafiomobile2you.features.details.interact.DetailsPresenterToInteract

class DetailsPresenter(private val view: DetailsViewToPresenter) : DetailsPresenterToMovie,
        DetailsPresenterToInteract {

        private val interact: DetailsInteractToPresenter by lazy {
            DetailsInteract(this)
        }
}