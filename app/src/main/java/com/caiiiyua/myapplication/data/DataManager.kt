package com.caiiiyua.myapplication.data

import com.caiiiyua.myapplication.data.remote.RibotApiService
import com.caiiiyua.myapplication.data.remote.model.Ribot
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by CaiY on 22/02/18.
 */
@Singleton
class DataManager @Inject constructor(private val ribotApiService: RibotApiService) {

    fun getRibots(): Observable<List<Ribot>> {
        return ribotApiService.getRibots()
    }
}