package com.app.k1.ed.workmate_countries.ui.screens.listcountry

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.app.k1.ed.workmate_countries.R
import com.app.k1.ed.workmate_countries.ui.navigation.Screens
import com.app.k1.ed.workmate_countries.ui.screens.MainViewModel
import com.app.k1.ed.workmate_countries.ui.screens.listcountry.components.CountryRow
import com.app.k1.ed.workmate_countries.ui.screens.listcountry.state.ListCountriesEvent
import com.app.k1.ed.workmate_countries.ui.screens.listcountry.state.ListCountriesState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCountryScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    val state by viewModel.status.collectAsState()
    val countries by viewModel.countries.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.txt_countries)) },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more),
                            contentDescription = null,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(countries) { index, country ->
                    CountryRow(
                        country,
                        onClick = {
                            viewModel.onNewIntent(ListCountriesEvent.OnClickCountry(index))
                            navController.navigate(Screens.DetailsCountryScreen.route)
                        }
                    )
                }
            }

            if (state is ListCountriesState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }

    LaunchedEffect(key1 = state) {
        when (state) {
            is ListCountriesState.Error -> Toast.makeText(
                context,
                (state as ListCountriesState.Error).error,
                Toast.LENGTH_SHORT
            ).show()

            else -> {}
        }
    }
}