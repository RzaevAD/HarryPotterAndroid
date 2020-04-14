package com.loftblog.hogwardtslibrary.domain.repositories

import com.loftblog.hogwardtslibrary.domain.models.StudentModel
import com.loftblog.hogwardtslibrary.ui.students.adapters.StudentCellModel

interface StudentsRepository {
        suspend fun fetchStudents(): List<StudentModel>
}