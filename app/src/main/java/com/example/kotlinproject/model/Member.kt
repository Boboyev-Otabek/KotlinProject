package com.example.kotlinproject.model

import java.io.Serializable

class Member(var name:String,var age:Int):Serializable {
    override fun toString(): String {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}