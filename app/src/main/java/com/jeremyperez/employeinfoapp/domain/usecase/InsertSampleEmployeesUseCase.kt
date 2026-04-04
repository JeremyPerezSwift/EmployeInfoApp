package com.jeremyperez.employeinfoapp.domain.usecase

import com.jeremyperez.employeinfoapp.domain.model.Employee
import com.jeremyperez.employeinfoapp.domain.repository.EmployeeRepository

class InsertSampleEmployeesUseCase(
    private val repository: EmployeeRepository
) {
    suspend operator fun invoke() {
        val sampleEmployees = listOf(
            Employee(
                name = "John Doe",
                designation = "Software Engineer",
                department = "Engineering"
            ),
            Employee(
                name = "Jane Smith",
                designation = "Product Manager",
                department = "Product"
            ),
            Employee(
                name = "Mike Johnson",
                designation = "UI/UX Designer",
                department = "Design"
            ),
            Employee(
                name = "Sarah Williams",
                designation = "DevOps Engineer",
                department = "Engineering"
            ),
            Employee(
                name = "David Brown",
                designation = "QA Engineer",
                department = "Quality Assurance"
            ),
            Employee(
                name = "Emily Davis",
                designation = "Marketing Manager",
                department = "Marketing"
            ),
            Employee(
                name = "Chris Wilson",
                designation = "Data Analyst",
                department = "Analytics"
            ),
            Employee(
                name = "Lisa Anderson",
                designation = "HR Manager",
                department = "Human Resources"
            )
        )

        repository.insertAllEmployees(sampleEmployees)
    }
}