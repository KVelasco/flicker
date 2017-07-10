package com.example.kevin.myapplication.injection.component

import com.example.kevin.myapplication.injection.PerFragment
import com.example.kevin.myapplication.injection.module.FragmentModule
import dagger.Component

@PerFragment
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent