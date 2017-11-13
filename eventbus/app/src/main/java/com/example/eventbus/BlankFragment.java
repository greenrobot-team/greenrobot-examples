package com.example.eventbus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eventbus.library.BlankBaseLibraryFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BlankFragment extends BlankBaseLibraryFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    // subscribe annotation in base class would not be picked up by index
    public void handleEvent(BlankBaseLibraryFragment.SampleEvent event) {
        super.handleEvent(event);
    }
}
