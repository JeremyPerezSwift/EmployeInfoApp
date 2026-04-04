package com.jeremyperez.employeinfoapp.domain.usecase

import com.jeremyperez.employeinfoapp.domain.model.Employee
import com.jeremyperez.employeinfoapp.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow

class GetAllEmployeesUseCase(
    private val repository: EmployeeRepository
) {
    operator fun invoke(): Flow<List<Employee>> {
        return repository.getAllEmployees()
    }
}