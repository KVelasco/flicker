package com.example.kevin.myapplication.api

import com.example.kevin.myapplication.model.PhotoResponse
import com.example.kevin.myapplication.model.RecentResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject
constructor(private val flickerService: FlickerService) {

    fun getRecentPhotos(method: String, apiKey: String, extras: String, format: String, nojsoncallback: String): Single<RecentResponse> {
        return flickerService.getRecent(method, apiKey, extras, format, nojsoncallback)
    }
}