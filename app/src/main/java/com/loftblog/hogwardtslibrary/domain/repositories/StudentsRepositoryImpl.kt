package com.loftblog.hogwardtslibrary.domain.repositories

import com.loftblog.hogwardtslibrary.domain.models.StudentModel
import kotlinx.coroutines.delay

class StudentsRepositoryImpl: StudentsRepository {

    override suspend fun fetchStudents(): List<StudentModel> {
        delay(2000)

        return listOf(
            StudentModel(id = 0, name = "Harry", secondName = "Potter", facultyName = "Griffindor"),
            StudentModel(id = 1, name = "Ronald", secondName = "Whisley", facultyName = "Griffindor"),
            StudentModel(id = 2, name = "Drako", secondName = "Malfoy", facultyName = "Slytherin"),
            StudentModel(id = 3, name = "Sedrik", secondName = "Diggory", facultyName = "Rawenclaw")
        )
    }
}