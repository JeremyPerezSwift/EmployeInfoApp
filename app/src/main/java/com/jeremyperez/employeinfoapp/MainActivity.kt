package com.jeremyperez.employeinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jeremyperez.employeinfoapp.di.EmployeeContainer
import com.jeremyperez.employeinfoapp.presentation.EmployeeViewModel
import com.jeremyperez.employeinfoapp.presentation.EmployeeViewModelFactory
import com.jeremyperez.employeinfoapp.ui.EmployeeScreen
import com.jeremyperez.employeinfoapp.ui.theme.EmployeInfoAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var employeeContainer: EmployeeContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        employeeContainer = EmployeeContainer(applicationContext)

        enableEdgeToEdge()
        setContent {
            EmployeInfoAppTheme {
                val viewModel: EmployeeViewModel = viewModel(
                    factory = EmployeeViewModelFactory(
                        getAllEmployeesUseCase = employeeContainer.getAllEmployeesUseCase,
                        insertEmployeeUseCase = employeeContainer.insertEmployeeUseCase,
                        insertSampleEmployeesUseCase = employeeContainer.insertSampleEmployeesUseCase
                    )
                )

                EmployeeScreen(viewModel = viewModel)
            }
        }
    }
}
