package com.applecompose.weather.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SearchScreen(navController: NavController) {
	Scaffold(topBar = {}) {
		Surface() {
			Column {
				Text(text = "Search Screen")

			}

		}

	}
}