package com.cehdoliveira.desafiomobile2you.support

import android.app.Application
import com.cehdoliveira.desafiomobile2you.service.SyncApi

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        SyncApi()
    }
}