package com.example.xmljdbc.service

import com.example.xmljdbc.dto.StudentsDto
import com.example.xmljdbc.entity.Skill
import com.example.xmljdbc.entity.Student
import com.example.xmljdbc.repository.StudentDao
import jakarta.xml.bind.JAXBContext
import org.springframework.stereotype.Service

@Service
class XmlImportService(private val studentDao: StudentDao) {

    fun importFromXml(): String {
        val inputStream = this::class.java.classLoader.getResourceAsStream("students.xml")
            ?: return "students.xml not found"

        val jaxbContext = JAXBContext.newInstance(StudentsDto::class.java)
        val unmarshaller = jaxbContext.createUnmarshaller()
        val studentsDto = unmarshaller.unmarshal(inputStream) as StudentsDto

        if (studentsDto.students.isEmpty()) {
            return "Import successful: 0 students"
        }

        for (studentDto in studentsDto.students) {
            val studentId = studentDao.saveStudent(Student(name = studentDto.name))
            for (skillName in studentDto.skills) {
                studentDao.saveSkill(Skill(studentId = studentId, name = skillName))
            }
        }

        val details = buildString {
            appendLine("Import successful: ${studentsDto.students.size} students")
            studentsDto.students.forEach { student ->
                appendLine("Student name: ${student.name}")
                if (student.skills.isEmpty()) {
                    appendLine("  No skills found")
                } else {
                    appendLine("  Skills:")
                    student.skills.forEach { skill ->
                        appendLine("    - $skill")
                    }
                }
            }
        }

        return "<html><body>${details.replace("\n", "<br>")}</body></html>"

    }

}
