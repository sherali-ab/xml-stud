package com.example.xmljdbc.controller

import com.example.xmljdbc.service.XmlImportService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ImportController(private val importService: XmlImportService) {

    @GetMapping("/import")
    fun importXml(): String {
        return importService.importFromXml()
    }
}
