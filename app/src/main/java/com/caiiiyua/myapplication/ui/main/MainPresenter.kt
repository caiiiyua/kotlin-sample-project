package com.caiiiyua.myapplication.ui.main

import com.caiiiyua.myapplication.base.injection.scopes.ConfigPersist
import com.caiiiyua.myapplication.data.DataManager
import com.caiiiyua.myapplication.data.remote.model.Ribot
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by pp on 22/02/18.
 */
@ConfigPersist
class MainPresenter
    @Inject
    constructor(private val dataManager: DataManager) : MainContract.Presenter() {

    private var disposable: Disposable? = null

    override fun detachView() {
        super.detachView()
        disposable?.dispose()
    }

    override fun loadRibots() {
        disposable?.dispose()
        disposable = dataManager.getRibots()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    t: List<Ribot>? -> if (t != null) {
                        if (!t.isEmpty()) view.showRibots(t) else view.showRibotsEmpty()
                    } else view.showError()
                }, {
                    t: Throwable? -> view.showError()
                })
    }

}