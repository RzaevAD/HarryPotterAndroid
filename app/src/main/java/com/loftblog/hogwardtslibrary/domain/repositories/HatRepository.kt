package com.loftblog.hogwardtslibrary.domain.repositories

import com.loftblog.hogwardtslibrary.domain.models.FacultyModel

interface HatRepository {
    suspend fun generateFaculty(username: String): FacultyModel
}