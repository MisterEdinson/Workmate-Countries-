package com.app.k1.ed.workmate_countries.ui.screens.listcountry.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.k1.ed.workmate_countries.data.Country

@Composable
fun CountryRow(
    country: Country,
    onClick: (name: String) -> Unit
) {
    ListItem(
        headlineContent = { Text(country.name) },
        leadingContent = {
            AsyncImage(
                model = country.flagUrl,
                contentDescription = country.name,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        },
        modifier = Modifier.clickable { onClick(country.name) }
    )
    Divider()
}