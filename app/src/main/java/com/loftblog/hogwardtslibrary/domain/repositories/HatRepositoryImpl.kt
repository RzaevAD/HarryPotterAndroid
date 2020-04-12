package com.loftblog.hogwardtslibrary.domain.repositories

import com.loftblog.hogwardtslibrary.domain.models.FacultyModel
import kotlinx.coroutines.delay

class HatRepositoryImpl: HatRepository {
    override suspend fun generateFaculty(username: String): FacultyModel {
        delay(3000)

        return if (username == "Harry Potter") {
            FacultyModel(name = "Griffendor")
        } else {
            FacultyModel(name = "Slytherin")
        }
    }
}