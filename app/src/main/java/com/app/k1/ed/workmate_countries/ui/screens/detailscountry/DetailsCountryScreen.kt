package com.app.k1.ed.workmate_countries.ui.screens.detailscountry

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.app.k1.ed.workmate_countries.R
import com.app.k1.ed.workmate_countries.ui.screens.MainViewModel
import com.app.k1.ed.workmate_countries.ui.screens.detailscountry.components.DetailsField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsCountryScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    val state by viewModel.status.collectAsState()
    val countries by viewModel.countries.collectAsState()
    val selected by viewModel.selectCountry.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
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
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxSize()
        ) {

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(

                        text = countries[selected].name,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    AsyncImage(
                        model = countries[selected].flagPng,
                        contentDescription = countries[selected].name,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(6.dp))
                    )
                }

                Spacer(Modifier.height(24.dp))
            }
            item {
                DetailsField(
                    title = stringResource(R.string.txt_continent),
                    value = countries[selected].continents ?: ""
                )
            }
            item {
                DetailsField(
                    title = stringResource(R.string.txt_capital),
                    value = countries[selected].capital ?: ""
                )
            }
            item {
                DetailsField(
                    title = stringResource(R.string.txt_region),
                    value = countries[selected].region.toString()
                )
            }
            item {
                DetailsField(
                    title = stringResource(R.string.txt_population),
                    value = countries[selected].population.toString()
                )
            }
            item {
                DetailsField(
                    title = stringResource(R.string.txt_area),
                    value = countries[selected].area.toString()
                )
            }
            item {
                DetailsField(
                    title = stringResource(R.string.txt_currency),
                    value = countries[selected].currencies ?: ""
                )
            }
            item {
                DetailsField(
                    title = stringResource(R.string.txt_timezones),
                    value = countries[selected].timezones ?: ""
                )
            }
        }
    }
}
