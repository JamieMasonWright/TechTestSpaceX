package com.javajj.lushTechTest.di

import com.javajj.lushTechTest.viewmodel.RocketViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
   viewModel { RocketViewModel(get()) }
}

