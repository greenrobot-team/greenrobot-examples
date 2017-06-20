package com.example.eventbuskotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(sticky = true)
    fun handleEvent(event: BlankBaseFragment.SampleEvent) {
        val className = this.javaClass.simpleName
        val message = "#handleEvent: called for " + event.javaClass.simpleName
        Toast.makeText(this, className + message, Toast.LENGTH_SHORT).show()
        Log.d(className, message)

        // prevent event from re-delivering, like when leaving and coming back to app
        EventBus.getDefault().removeStickyEvent(event)
    }

    fun onPostButtonClick(view: View) {
        EventBus.getDefault().post(BlankBaseFragment.SampleEvent())
    }

    fun onLaunchButtonClick(view: View) {
        startActivity(Intent(this, EmptyActivity::class.java))
    }
}
