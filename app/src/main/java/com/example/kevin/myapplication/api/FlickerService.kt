package com.example.kevin.myapplication.api

import com.example.kevin.myapplication.model.PhotoResponse
import com.example.kevin.myapplication.model.RecentResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickerService {


    @GET("rest") fun getRecent(@Query("method") method: String,
                                 @Query("api_key") API_KEY: String,
                                 @Query("extras") EXTRA_SMALL_URL: String,
                                 @Query("format") format: String,
                                 @Query("nojsoncallback") set: String): Single<RecentResponse>
}