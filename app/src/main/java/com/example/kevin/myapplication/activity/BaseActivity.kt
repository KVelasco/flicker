package com.example.kevin.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import butterknife.ButterKnife
import com.example.kevin.myapplication.FlickerApplication
import com.example.kevin.myapplication.injection.component.ActivityComponent
import com.example.kevin.myapplication.injection.component.DaggerActivityComponent

abstract class BaseActivity : AppCompatActivity() {

    private var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent  = DaggerActivityComponent.builder()
                .appComponent(FlickerApplication[this].component)
                .build()
        activityComponent?.inject(this)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        ButterKnife.bind(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun activityComponent(): ActivityComponent {
        return activityComponent as ActivityComponent
    }
}