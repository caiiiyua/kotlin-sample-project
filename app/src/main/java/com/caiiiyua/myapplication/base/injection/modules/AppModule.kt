package com.caiiiyua.myapplication.base.injection.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.caiiiyua.myapplication.base.injection.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by CaiY on 16/02/18.
 */
@Module
class AppModule(val application: Application) {
  @Provides
  @Singleton
  fun provideApplication(): Application = application

  @Provides
  @Singleton
  @ApplicationContext
  fun provideContext(): Context = application

  @Provides
  @Singleton
  fun provideResources(): Resources = application.resources
}