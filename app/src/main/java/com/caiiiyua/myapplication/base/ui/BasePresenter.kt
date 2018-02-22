package com.caiiiyua.myapplication.base.ui

/**
 * Created by CaiY on 22/02/18.
 */
open class BasePresenter<V : BaseView> : Presenter<V> {

  private val _isViewAttached: Boolean get() = _view != null
  private var _view: V? = null

  val view: V get() = _view ?: throw ViewNotAttachedException()

  override fun attachView(view: V) {
    if (!_isViewAttached) {
      _view = view
    }
  }

  override fun detachView() {
    _view = null
  }

  fun isViewAttached(): Boolean = _isViewAttached

  class ViewNotAttachedException : RuntimeException (
          "Please call Presenter.attachView(MvpView) before requesting data to the Presenter"
  )

}