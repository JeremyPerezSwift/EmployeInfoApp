package com.jeremyperez.employeinfoapp.di

import android.content.Context
import com.jeremyperez.employeinfoapp.data.local.dao.EmployeeDao
import com.jeremyperez.employeinfoapp.data.local.database.EmployeeDatabase
import com.jeremyperez.employeinfoapp.data.repository.EmployeeRepositoryImpl
import com.jeremyperez.employeinfoapp.domain.repository.EmployeeRepository
import com.jeremyperez.employeinfoapp.domain.usecase.GetAllEmployeesUseCase
import com.jeremyperez.employeinfoapp.domain.usecase.InsertEmployeeUseCase
import com.jeremyperez.employeinfoapp.domain.usecase.InsertSampleEmployeesUseCase

class EmployeeContainer(context: Context) {
    private val database: EmployeeDatabase = EmployeeDatabase.getDatabase(context)
    private val employeeDao: EmployeeDao = database.employeeDao()

    val repository: EmployeeRepository = EmployeeRepositoryImpl(employeeDao)

    val getAllEmployeesUseCase = GetAllEmployeesUseCase(repository)
    val insertEmployeeUseCase = InsertEmployeeUseCase(repository)
    val insertSampleEmployeesUseCase = InsertSampleEmployeesUseCase(repository)
}