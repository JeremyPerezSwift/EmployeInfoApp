package com.jeremyperez.employeinfoapp.domain.repository

import com.jeremyperez.employeinfoapp.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    fun getAllEmployees(): Flow<List<Employee>>
    suspend fun insertEmployee(employee: Employee)
    suspend fun insertAllEmployees(employees: List<Employee>)
}