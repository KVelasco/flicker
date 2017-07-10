package com.example.kevin.myapplication.activity

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import butterknife.BindView
import com.example.kevin.myapplication.R
import com.example.kevin.myapplication.model.Photo
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMvpView {

    @Inject lateinit var mMainPresenter: MainPresenter

    @BindView(R.id.main_toolbar) @JvmField var toolbar: Toolbar? = null

    @BindView(R.id.main_app_bar_layout) @JvmField var appBarLayout: AppBarLayout? = null

    @BindView(R.id.main_view_pager) @JvmField var viewPager: ViewPager? = null

    @BindView(R.id.main_coordinator_layout) @JvmField var coordinatorLayout: CoordinatorLayout? = null

    @BindView(R.id.progress) @JvmField var progress: ProgressBar? = null

    private var pagerAdapter: FlickerPagerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent().inject(this)
        mMainPresenter.attachView(this)
        initToolbar()
        setupTabs()
        mMainPresenter.getRecentPhotos("flickr.photos.getRecent",
                "d08e4af2a8451c9269fd19d9d7cc2809",
                "url_l",
                "json",
                "1")
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.detachView()
    }

    override fun showPhotos(photos: List<Photo>) {
       pagerAdapter?.addPhotos(photos)
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progress?.visibility = View.VISIBLE
            viewPager?.visibility = View.GONE
        } else {
            progress?.visibility = View.GONE
            viewPager?.visibility = View.VISIBLE
        }
    }

    override fun showError(error: Throwable) {
        Snackbar.make(coordinatorLayout!!, error.message.toString(), Snackbar.LENGTH_LONG).show()
    }

    private fun initToolbar() {
        toolbar?.inflateMenu(R.menu.main_menu_activity)
        toolbar?.setOnMenuItemClickListener { item -> false }
        toolbar?.setTitle("Flicker")
    }

    fun setupTabs() {
        pagerAdapter = FlickerPagerAdapter(this)
        viewPager?.setAdapter(pagerAdapter)
    }
}
