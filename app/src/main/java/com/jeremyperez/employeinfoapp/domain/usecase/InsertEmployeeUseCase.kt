package com.jeremyperez.employeinfoapp.domain.usecase

import com.jeremyperez.employeinfoapp.domain.model.Employee
import com.jeremyperez.employeinfoapp.domain.repository.EmployeeRepository

class InsertEmployeeUseCase(
    private val repository: EmployeeRepository
) {
    suspend operator fun invoke(employee: Employee) {
        repository.insertEmployee(employee)
    }
}