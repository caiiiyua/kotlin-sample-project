package com.caiiiyua.myapplication.ui.main

import com.caiiiyua.myapplication.base.ui.BasePresenter
import com.caiiiyua.myapplication.base.ui.BaseView
import com.caiiiyua.myapplication.data.remote.model.Ribot

/**
 * Created by pp on 22/02/18.
 */
object MainContract {
    interface View: BaseView {
        fun showRibots(ribots: List<Ribot>)
        fun showRibotsEmpty()
        fun showError()
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun loadRibots()
    }
}