package com.loftblog.hogwardtslibrary.ui.hat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loftblog.hogwardtslibrary.domain.repositories.HatRepository
import com.loftblog.hogwardtslibrary.domain.repositories.HatRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HatViewModel: ViewModel() {

    private lateinit var hatRepository: HatRepository

    init {
        hatRepository = HatRepositoryImpl()
    }

    private val _username: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    private val _facultyName: MutableLiveData<String> = MutableLiveData<String>().apply{value = ""}

    val facultyName: LiveData<String> = _facultyName
    val isLoading: LiveData<Boolean> = _isLoading

    fun applyUserName(name: String) {
        _username.postValue(name)
    }

    fun getFacultyName() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.IO) {
                _facultyName.postValue(hatRepository.generateFaculty(username = _username.value ?: "").name)
                _isLoading.postValue(false)
            }
        }
    }
}