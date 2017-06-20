package com.example.eventbuskotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.Subscribe

class BlankFragment : BlankBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    @Subscribe // subscribe annotation in base class would not be picked up by index
    override fun handleEvent(event: BlankBaseFragment.SampleEvent) {
        super.handleEvent(event)
    }

    class SampleEvent
}
