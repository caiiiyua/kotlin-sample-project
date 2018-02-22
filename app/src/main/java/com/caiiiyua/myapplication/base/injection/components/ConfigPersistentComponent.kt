package com.caiiiyua.myapplication.base.injection.components

import com.caiiiyua.myapplication.base.injection.modules.ActivityModule
import com.caiiiyua.myapplication.base.injection.scopes.ConfigPersist
import dagger.Component
import dagger.Provides

/**
 * Created by pp on 22/02/18.
 */
@ConfigPersist
@Component(dependencies = arrayOf(AppComponent::class))
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}