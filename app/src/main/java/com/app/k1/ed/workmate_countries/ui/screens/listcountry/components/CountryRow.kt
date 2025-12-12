package com.app.k1.ed.workmate_countries.ui.screens.listcountry.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.k1.ed.workmate_countries.data.local.entity.CountryEntity

@Composable
fun CountryRow(
    country: CountryEntity,
    onClick: () -> Unit
) {
    var imageUrl by remember { mutableStateOf(country.flagPng) }
    var loadError by remember { mutableStateOf(false) }

    ListItem(
        headlineContent = { Text(country.name, color = MaterialTheme.colorScheme.onSurface) },
        leadingContent = {
            AsyncImage(
                model = imageUrl,
                contentDescription = country.name,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(4.dp)),
                onError = {
                    if (!loadError) {
                        loadError = true
                        imageUrl = country.flagSvg ?: ""
                    }
                }
            )
        },
        modifier = Modifier.clickable { onClick() },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background,
            headlineColor = MaterialTheme.colorScheme.onSurface
        )
    )
    HorizontalDivider()
}