package com.caiiiyua.myapplication.data.remote

import com.caiiiyua.myapplication.data.remote.model.Ribot
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by pp on 22/02/18.
 */
interface RibotApiService {

    @GET("ribots")
    fun getRibots(): Observable<List<Ribot>>
}