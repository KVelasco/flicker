package com.example.kevin.myapplication.mvp

interface Presenter<in V> where V : MvpView {

    fun attachView(mvpView: V)

    fun detachView()
}