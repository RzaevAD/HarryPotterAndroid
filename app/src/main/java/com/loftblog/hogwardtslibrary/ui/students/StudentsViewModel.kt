package com.loftblog.hogwardtslibrary.ui.students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loftblog.hogwardtslibrary.domain.models.StudentModel
import com.loftblog.hogwardtslibrary.domain.repositories.StudentsRepository
import com.loftblog.hogwardtslibrary.domain.repositories.StudentsRepositoryImpl
import com.loftblog.hogwardtslibrary.ui.students.adapters.StudentCellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentsViewModel : ViewModel() {

    private val studentsRepository = StudentsRepositoryImpl()

    private val _students = MutableLiveData<List<StudentCellModel>>().apply {
        value = ArrayList()
    }

    private val _isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    val students: LiveData<List<StudentCellModel>> = _students
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchStudents() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.Default) {
                val students = studentsRepository.fetchStudents()
                _isLoading.postValue(false)
                _students.postValue(students.map{ StudentCellModel(
                    id = it.id, name = "${it.name} ${it.secondName}", facultyName = it.facultyName
                )})
            }
        }
    }
}