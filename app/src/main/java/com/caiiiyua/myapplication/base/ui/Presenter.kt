package com.caiiiyua.myapplication.base.ui

/**
 * Created by CaiY on 22/02/18.
 */
interface Presenter<V: BaseView> {
  fun attachView(view: V)
  fun detachView()
}