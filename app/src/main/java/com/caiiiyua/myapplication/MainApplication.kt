package com.caiiiyua.myapplication

import android.app.Application
import com.caiiiyua.myapplication.base.injection.components.AppComponent
import com.caiiiyua.myapplication.base.injection.components.DaggerAppComponent
import com.caiiiyua.myapplication.base.injection.modules.AppModule
import timber.log.Timber

/**
 * Created by CaiY on 22/02/18.
 */

class MainApplication : Application() {

  val component: AppComponent by lazy {
    DaggerAppComponent.builder().appModule(AppModule(this)).build()
  }

  override fun onCreate() {
    super.onCreate()
    component.inject(this)
    if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
  }
}