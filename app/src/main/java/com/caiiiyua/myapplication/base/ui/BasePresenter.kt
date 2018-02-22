package com.caiiiyua.myapplication.base.ui

import java.lang.ref.WeakReference

/**
 * Created by CaiY on 22/02/18.
 */
open class BasePresenter<V : BaseView> : Presenter<V> {
  private var weakReference: WeakReference<V>? = null

  override fun attachView(view: V) {
    if (!isViewAttached) {
      weakReference = WeakReference(view)
      view.setPresenter(this)
    }
  }

  override fun detachView() {
    weakReference?.clear()
    weakReference = null
  }

  private val isViewAttached: Boolean
    get() = weakReference != null && weakReference!!.get() != null

  val view: V? get() = weakReference?.get()

}