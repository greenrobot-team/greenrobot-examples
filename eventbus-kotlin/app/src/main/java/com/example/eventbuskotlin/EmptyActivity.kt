package com.example.eventbuskotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import org.greenrobot.eventbus.EventBus

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
    }

    fun onPostStickyButtonClick(view: View) {
        EventBus.getDefault().postSticky(BlankBaseFragment.SampleEvent())
        finish()
    }

}
