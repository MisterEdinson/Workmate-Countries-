package com.app.k1.ed.workmate_countries.ui.screens.detailscountry

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.k1.ed.workmate_countries.ui.screens.MainViewModel
import com.app.k1.ed.workmate_countries.ui.theme.MainBlack
import com.app.k1.ed.workmate_countries.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsCountryScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
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
                            contentDescription = "Назад",
                            tint = MainBlack
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PurpleGrey80
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

//            item {
//                InfoSection(title = "Continent", value = country.continent)
//            }
//
//            item {
//                InfoSection(title = "Capital", value = country.capital)
//            }
//
//            item {
//                InfoSection(title = "Language", value = country.language)
//            }
//
//            item {
//                InfoSection(title = "Currency", value = country.currency)
//            }
//
//            item {
//                InfoSection(
//                    title = "Other details",
//                    value = country.emojiFlag,
//                    trailingContent = {
//                        Text(
//                            text = country.emojiFlag,
//                            fontSize = 26.sp
//                        )
//                    }
//                )
//            }
        }
    }
}
