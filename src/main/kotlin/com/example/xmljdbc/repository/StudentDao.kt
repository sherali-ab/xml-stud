package com.example.xmljdbc.repository

import com.example.xmljdbc.entity.*
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement

@Repository
open class StudentDao(private val jdbc: JdbcTemplate) {

    fun saveStudent(student: Student): Long {
        val sql = "INSERT INTO students(name) VALUES (?)"
        val keyHolder: KeyHolder = GeneratedKeyHolder()
        jdbc.update({ con ->
            val ps: PreparedStatement = con.prepareStatement(sql, arrayOf("id"))
            ps.setString(1, student.name)
            ps
        }, keyHolder)
        return keyHolder.key?.toLong() ?: throw RuntimeException("No ID returned")
    }

    fun saveSkill(skill: Skill) {
        jdbc.update("INSERT INTO skills(student_id, name) VALUES (?, ?)", skill.studentId, skill.name)
    }
}
