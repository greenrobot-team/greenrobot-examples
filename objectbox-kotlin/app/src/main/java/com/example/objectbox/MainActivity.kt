package com.example.objectbox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.objectbox.entities.SimpleEntity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        putAndGetSimpleEntity()
    }

    private fun putAndGetSimpleEntity() {
        val simpleEntity = SimpleEntity(null, 1, 1, 1)

        val box = ExampleApp.getBoxStore(this).boxFor(SimpleEntity::class.java)
        val simpleEntityId = box.put(simpleEntity)

        val simpleEntityLoaded = box.get(simpleEntityId)
    }

}
