package com.example.xmljdbc.dto

import jakarta.xml.bind.annotation.*

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
class StudentsDto() {
    @XmlElement(name = "student")
    var students: List<StudentDto> = mutableListOf()
}

@XmlAccessorType(XmlAccessType.FIELD)
class StudentDto() {
    var name: String = ""

    @XmlElementWrapper(name = "skills")
    @XmlElement(name = "skill")
    var skills: List<String> = mutableListOf()
}
