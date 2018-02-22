package com.caiiiyua.myapplication.base.injection.components

import android.app.Application
import com.caiiiyua.myapplication.base.injection.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by CaiY on 16/02/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(app: Application)
  fun application(): Application
}