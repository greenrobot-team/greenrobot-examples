package com.example.objectbox.entities

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class SimpleEntity(
        @Id var _id: Long = 0,
        val simpleShort: Short?,
        val simpleInt: Int?,
        val simpleLong: Long?
)