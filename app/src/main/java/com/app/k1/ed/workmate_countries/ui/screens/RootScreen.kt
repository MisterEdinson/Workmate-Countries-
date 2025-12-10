package com.app.k1.ed.workmate_countries.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.k1.ed.workmate_countries.ui.navigation.NavGraph

@Composable
fun RootScreen(
    viewModel: MainViewModel
){
    val navController = rememberNavController()
    AppContent( navController, viewModel )
}

@SuppressLint("ContextCastToActivity")
@Composable
fun AppContent(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    val insets = WindowInsets.systemBars.asPaddingValues()
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(insets),
    ) { paddingValues ->
        NavGraph(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            viewModel = viewModel
        )
    }
}