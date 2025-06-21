package com.example.xmljdbc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class XmlJdbcApplication

fun main(args: Array<String>) {
    runApplication<XmlJdbcApplication>(*args)
}
// http://localhost:8080/import