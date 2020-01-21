package com.example.eventbus.library;

import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import androidx.fragment.app.Fragment;

public abstract class BlankBaseLibraryFragment extends Fragment {

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void handleEvent(SampleEvent event) {
        String className = this.getClass().getSimpleName();
        String message = "#handleEvent: called for " + event.getClass().getSimpleName();
        Toast.makeText(getContext(), className + message, Toast.LENGTH_SHORT).show();
        Log.d(className, message);
    }

    public static class SampleEvent {
    }
}
