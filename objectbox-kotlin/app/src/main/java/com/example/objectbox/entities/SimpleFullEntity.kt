package com.example.objectbox.entities

import io.objectbox.annotation.Id

//@Entity
class SimpleFullEntity {

    @Id var _id: Long? = null
    var simpleShort: Short? = null
    var simpleInt: Int? = null
    var simpleLong: Long? = null

}