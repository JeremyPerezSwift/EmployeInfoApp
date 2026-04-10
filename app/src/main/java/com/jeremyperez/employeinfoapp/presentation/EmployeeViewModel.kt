package com.jeremyperez.employeinfoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremyperez.employeinfoapp.domain.usecase.GetAllEmployeesUseCase
import com.jeremyperez.employeinfoapp.domain.usecase.InsertEmployeeUseCase
import com.jeremyperez.employeinfoapp.domain.usecase.InsertSampleEmployeesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val getAllEmployeesUseCase: GetAllEmployeesUseCase,
    private val insertEmployeeUseCase: InsertEmployeeUseCase,
    private val insertSampleEmployeesUseCase: InsertSampleEmployeesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<EmployeeUIState>(
        EmployeeUIState.Loading
    )
    val uiState: StateFlow<EmployeeUIState> = _uiState.asStateFlow()

    init {
        loadEmployees()
    }

    private fun loadEmployees() {
        viewModelScope.launch {
            getAllEmployeesUseCase()
                .catch { exception ->
                    _uiState.value = EmployeeUIState.Error(
                        message = exception.message ?: "Unknown error occurred"
                    )
                }
                .collect { employees ->
                    _uiState.value = EmployeeUIState.Success(
                        employees = employees
                    )
                }
        }
    }


}