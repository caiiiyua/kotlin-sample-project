package com.caiiiyua.myapplication

import com.caiiiyua.myapplication.data.DataManager
import com.caiiiyua.myapplication.data.remote.model.Ribot
import com.caiiiyua.myapplication.ui.main.MainContract
import com.caiiiyua.myapplication.ui.main.MainPresenter
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by pp on 23/02/18.
 */
@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Rule @JvmField
    val schedulersRule: RxSchedulersRule = RxSchedulersRule()

    @Mock
    lateinit var mockDataManager: DataManager
    @Mock
    lateinit var mockMainView: MainContract.View

    lateinit var mainPresenter: MainPresenter

    @Before
    fun setUp() {
        mainPresenter = MainPresenter(mockDataManager)
        mainPresenter.attachView(mockMainView)
    }

    @Test
    fun loadRibots() {
        val ribots = listOf(TestDataFactory.makeRibot("r1"), TestDataFactory.makeRibot("r2"))
        whenever(mockDataManager.getRibots()).thenReturn(Observable.just(ribots))

        mainPresenter.loadRibots()

        verify(mockMainView).showRibots(ribots)
        verify(mockMainView, never()).showRibotsEmpty()
        verify(mockMainView, never()).showError()
    }

    @Test
    fun loadRibotsEmpty() {
        val ribots = emptyList<Ribot>()
        whenever(mockDataManager.getRibots()).thenReturn(Observable.just(ribots))

        mainPresenter.loadRibots()

        verify(mockMainView).showRibotsEmpty()
        verify(mockMainView, never()).showRibots(listOf())
        verify(mockMainView, never()).showError()
    }

    @Test
    fun loadRibotsError() {
        whenever(mockDataManager.getRibots()).thenReturn(Observable.error<List<Ribot>>(RuntimeException()))

        mainPresenter.loadRibots()

        verify(mockMainView).showError()
        verify(mockMainView, never()).showRibots(listOf())
        verify(mockMainView, never()).showRibotsEmpty()
    }

}