package com.jeremyperez.employeinfoapp.data.repository

import com.jeremyperez.employeinfoapp.data.local.dao.EmployeeDao
import com.jeremyperez.employeinfoapp.data.mapper.toDomainModels
import com.jeremyperez.employeinfoapp.data.mapper.toEntities
import com.jeremyperez.employeinfoapp.data.mapper.toEntity
import com.jeremyperez.employeinfoapp.domain.model.Employee
import com.jeremyperez.employeinfoapp.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmployeeRepositoryImpl(
    private val employeeDao: EmployeeDao
) : EmployeeRepository {
    override fun getAllEmployees(): Flow<List<Employee>> {
        return employeeDao.getAllEmployees()
            .map { entities -> entities.toDomainModels() }
    }

    override suspend fun insertEmployee(employee: Employee) {
        employeeDao.insertEmployee(employee.toEntity())
    }

    override suspend fun insertAllEmployees(employees: List<Employee>) {
        employeeDao.insertAllEmployees(employees.toEntities())
    }
}