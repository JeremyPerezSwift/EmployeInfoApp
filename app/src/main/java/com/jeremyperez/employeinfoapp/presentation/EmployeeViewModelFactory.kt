package com.jeremyperez.employeinfoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeremyperez.employeinfoapp.domain.usecase.GetAllEmployeesUseCase
import com.jeremyperez.employeinfoapp.domain.usecase.InsertEmployeeUseCase
import com.jeremyperez.employeinfoapp.domain.usecase.InsertSampleEmployeesUseCase

class EmployeeViewModelFactory(
    private val getAllEmployeesUseCase: GetAllEmployeesUseCase,
    private val insertEmployeeUseCase: InsertEmployeeUseCase,
    private val insertSampleEmployeesUseCase: InsertSampleEmployeesUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
            return EmployeeViewModel(
                getAllEmployeesUseCase,
                insertEmployeeUseCase,
                insertSampleEmployeesUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class")
    }
}