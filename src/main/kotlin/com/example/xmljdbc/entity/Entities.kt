package com.example.xmljdbc.entity

data class Student(val id: Long? = null, val name: String)
data class Skill(val id: Long? = null, val studentId: Long, val name: String)
