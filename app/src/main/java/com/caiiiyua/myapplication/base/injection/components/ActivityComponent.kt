package com.caiiiyua.myapplication.base.injection.components

import com.caiiiyua.myapplication.ui.main.MainActivity
import com.caiiiyua.myapplication.base.injection.modules.ActivityModule
import com.caiiiyua.myapplication.base.injection.scopes.PerActivity
import dagger.Subcomponent

/**
 * Created by pp on 22/02/18.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}