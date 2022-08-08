package com.applecompose.weather.presentation.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SearchScreen(navController: NavController) {
	Column(
				modifier = Modifier
					.fillMaxSize(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Top
				)

			{

				Text(
					text = "Search Screen",
					fontSize = 24.sp,
					)
				Spacer(modifier = Modifier.height(16.dp))
				Divider(thickness = 2.dp, color = MaterialTheme.colors.primaryVariant)
				Button(
					onClick = {  }) {
					Text(text = "Save")

				}

			}
}