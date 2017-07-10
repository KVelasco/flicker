package com.example.kevin.myapplication.activity

import com.example.kevin.myapplication.api.DataManager
import com.example.kevin.myapplication.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject
constructor(private val dataManager: DataManager) : BasePresenter<MainMvpView>() {

    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)
    }

    fun getRecentPhotos(method: String, apiKey: String, extras: String, format: String, nojsoncallback: String) {
        checkViewAttached()
        mvpView?.showProgress(true)
        dataManager.getRecentPhotos(method, apiKey, extras, format, nojsoncallback)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ (photos) ->
                    mvpView?.showProgress(false)
                    mvpView?.showPhotos(photos.photo.filter { photo -> photo.url_l != null })
                }) { throwable ->
                    mvpView?.showProgress(false)
                    mvpView?.showError(throwable)
                }
    }

}
