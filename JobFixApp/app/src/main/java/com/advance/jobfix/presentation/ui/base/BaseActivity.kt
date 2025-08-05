package com.advance.jobfix.presentation.ui.base

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable


abstract class BaseActivity: ComponentActivity() {

    private val TAG = BaseActivity::class.java.simpleName

    @Composable
    abstract fun Content()

    open fun onActivityStart(){
        Log.d(TAG, "onActivityStart")
    }
    open fun onActivityResume(){
        Log.d(TAG, "onActivityResume")
    }
    open fun onActivityPause(){
        Log.d(TAG, "onActivityPause")
    }
    open fun onActivityStop(){
        Log.d(TAG, "onActivityStop")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            Content()
        }
    }

    override fun onStart() {
        super.onStart()
        onActivityStart()
    }

    override fun onResume() {
        super.onResume()
        onActivityResume()
    }

    override fun onPause() {
        super.onPause()
        onActivityPause()
    }

    override fun onStop() {
        super.onStop()
        onActivityStop()
    }

}