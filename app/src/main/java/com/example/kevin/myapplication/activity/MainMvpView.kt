package com.example.kevin.myapplication.activity

import com.example.kevin.myapplication.model.Photo
import com.example.kevin.myapplication.mvp.MvpView

interface MainMvpView : MvpView {

    fun showPhotos(photos: List<Photo>)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}