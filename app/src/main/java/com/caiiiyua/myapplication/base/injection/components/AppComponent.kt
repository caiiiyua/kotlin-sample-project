package com.caiiiyua.myapplication.base.injection.components

import android.app.Application
import android.content.Context
import com.caiiiyua.myapplication.base.injection.modules.ApiModule
import com.caiiiyua.myapplication.base.injection.modules.AppModule
import com.caiiiyua.myapplication.base.injection.qualifier.ApplicationContext
import com.caiiiyua.myapplication.data.DataManager
import com.caiiiyua.myapplication.data.remote.RibotApiService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by CaiY on 16/02/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {
  fun inject(app: Application)
  fun application(): Application
  @ApplicationContext fun context(): Context
  fun ribotApiService(): RibotApiService
  fun dataManager(): DataManager
}