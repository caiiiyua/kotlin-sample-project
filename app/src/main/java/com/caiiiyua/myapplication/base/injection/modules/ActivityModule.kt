package com.caiiiyua.myapplication.base.injection.modules

import android.app.Activity
import android.content.Context
import com.caiiiyua.myapplication.base.injection.qualifier.ActivityContext
import com.caiiiyua.myapplication.base.injection.scopes.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by pp on 22/02/18.
 */
@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @PerActivity
    fun provideActivity(): Activity = activity

    @Provides
    @PerActivity
    @ActivityContext
    fun provideContext(): Context = activity
}