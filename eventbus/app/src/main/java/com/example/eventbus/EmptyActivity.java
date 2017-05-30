package com.example.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.eventbus.library.BlankBaseLibraryFragment;

import org.greenrobot.eventbus.EventBus;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
    }

    public void onPostStickyButtonClick(View view) {
        EventBus.getDefault().postSticky(new BlankBaseLibraryFragment.SampleEvent());
        finish();
    }

}
