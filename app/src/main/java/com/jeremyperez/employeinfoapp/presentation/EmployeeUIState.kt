package com.jeremyperez.employeinfoapp.presentation

import com.jeremyperez.employeinfoapp.domain.model.Employee

sealed interface EmployeeUIState {
    data object Loading: EmployeeUIState

    data class Success(
        val employees: List<Employee>,
        val isLoading: Boolean = false
    ): EmployeeUIState

    data class Error(val message: String): EmployeeUIState
}