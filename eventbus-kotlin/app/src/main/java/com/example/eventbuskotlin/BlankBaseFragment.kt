package com.example.eventbuskotlin

import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Toast
import org.greenrobot.eventbus.EventBus

abstract class BlankBaseFragment : Fragment() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    open fun handleEvent(event: SampleEvent) {
        val className = this.javaClass.simpleName
        val message = "#handleEvent: called for " + event.javaClass.simpleName
        Toast.makeText(context, className + message, Toast.LENGTH_SHORT).show()
        Log.d(className, message)
    }

    class SampleEvent
}
