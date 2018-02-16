package com.caiiiyua.myapplication.base.injection.modules

import android.app.Application
import android.content.res.Resources
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

  fun provideResources(): Resources = application.resources
}