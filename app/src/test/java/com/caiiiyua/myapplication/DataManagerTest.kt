package com.caiiiyua.myapplication

import com.caiiiyua.myapplication.data.DataManager
import com.caiiiyua.myapplication.data.remote.RibotApiService
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by pp on 23/02/18.
 */
@RunWith(MockitoJUnitRunner::class)
class DataManagerTest {

    @Mock
    lateinit var mockRibotsApiService: RibotApiService

    lateinit var dataManager: DataManager

    @Before
    fun setUp() {
        dataManager = DataManager(mockRibotsApiService)
    }

    @Test
    fun syncRibotsEmitsValues() {
        val ribots = listOf(TestDataFactory.makeRibot("r1"), TestDataFactory.makeRibot("r2"))
        whenever(mockRibotsApiService.getRibots()).thenReturn(Observable.just(ribots))

        dataManager.getRibots().subscribe({t ->
            run {
                assert(t != null)
                assert(t.size == ribots.size)
            }
        }, {t: Throwable? -> assert(false) })
    }

    @Test
    fun syncRibotsCallsApi() {
        val ribots = listOf(TestDataFactory.makeRibot("r1"), TestDataFactory.makeRibot("r2"))
        whenever(mockRibotsApiService.getRibots()).thenReturn(Observable.just(ribots))

        dataManager.getRibots().subscribe()

        verify(mockRibotsApiService).getRibots()
    }
}