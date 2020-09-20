package com.jorge_diaz.leagues.di

import android.app.Application

class LeaguesApplication : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}