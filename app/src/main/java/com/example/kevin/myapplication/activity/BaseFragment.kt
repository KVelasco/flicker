package com.example.kevin.myapplication.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.example.kevin.myapplication.FlickerApplication
import com.example.kevin.myapplication.injection.component.DaggerFragmentComponent
import com.example.kevin.myapplication.injection.component.FragmentComponent

abstract class BaseFragment : Fragment() {

    private var fragmentComponent: FragmentComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent = DaggerFragmentComponent.builder()
                .appComponent(FlickerApplication[activity].component)
                .build()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(layout, container, false)
        ButterKnife.bind(this, view as View)
        return view
    }

    abstract val layout: Int

    fun fragmentComponent(): FragmentComponent {
        return fragmentComponent as FragmentComponent
    }
}