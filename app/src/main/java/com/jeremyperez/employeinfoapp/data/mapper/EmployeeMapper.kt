package com.jeremyperez.employeinfoapp.data.mapper

import com.jeremyperez.employeinfoapp.data.local.entity.EmployeeEntity
import com.jeremyperez.employeinfoapp.domain.model.Employee

/**
 *  Convert Room entity domain model
 */
fun EmployeeEntity.toDomainModel(): Employee {
    return Employee(
        id = this.id,
        name = this.name,
        designation = this.designation,
        department = this.department,
    )
}

/**
 *  Convert domain model to Room entity
 */
fun Employee.toEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = this.id,
        name = this.name,
        designation = this.designation,
        department = this.department,
    )
}

/**
 *  Extension function to convert List<EmployeeEntity> to List<Employee>
 */
fun List<EmployeeEntity>.toDomainModels(): List<Employee> {
    return this.map { it.toDomainModel() }
}

/**
 *  Extension function to convert List<Employee> to List<EmployeeEntity>
 */
fun List<Employee>.toEntities(): List<EmployeeEntity> {
    return this.map { it.toEntity() }
}