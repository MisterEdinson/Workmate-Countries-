package com.app.k1.ed.workmate_countries

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.app.k1.ed.workmate_countries.ui.screens.MainViewModel
import com.app.k1.ed.workmate_countries.ui.screens.RootScreen
import com.app.k1.ed.workmate_countries.ui.theme.WorkmateCountriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkmateCountriesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootScreen(viewModel)
                }
            }
        }
    }
}