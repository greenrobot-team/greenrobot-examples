package com.example.objectbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.objectbox.entities.CustomTypes;

import java.util.Collections;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        putAndGetCustomTypes();
    }

    private void putAndGetCustomTypes() {
        CustomTypes customTypes = new CustomTypes();
        customTypes.customType = CustomTypes.SimpleEnum.DEFAULT;
        customTypes.customTypes = Collections.singletonList(CustomTypes.SimpleEnum.DEFAULT);

        Box<CustomTypes> box = ExampleApp.getBoxStore(this).boxFor(CustomTypes.class);
        long customTypeId = box.put(customTypes);

        CustomTypes customTypesLoaded = box.get(customTypeId);
    }

}
