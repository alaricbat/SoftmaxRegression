package com.advance.jobfix.presentation.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModel : ViewModel() {

    companion object {

        inline fun <reified vm: BaseViewModel> provideFactory (
            crossinline creator: () -> vm
        ) : ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(vm::class.java)) {
                    return creator() as T
                }
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        }

    }

}