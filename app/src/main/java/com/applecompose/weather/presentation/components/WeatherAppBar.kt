package com.applecompose.weather.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.applecompose.weather.navigation.screen.Screen

@Composable
fun WeatherAppBar(
	title: String,
	icon: ImageVector? = null,
	isMainScreen: Boolean = true,
	elevation: Dp = 0.dp,
	navController: NavController,
	onAddActionClicked: () -> Unit = {},
	onButtonClicked: () -> Unit = {},

	) {
	TopAppBar(
		title = {
			Text(
				text = title,
				style = TextStyle(
					fontWeight = FontWeight.Bold,
					fontSize = 16.sp
				)
				)
		},
		actions = {
				  if (isMainScreen){
					  IconButton(onClick = {
						 onAddActionClicked.invoke()
					  }) {
						  Icon(
							  imageVector = Icons.Default.Search,
							  contentDescription = "Search Icon")
					  }
					  IconButton(onClick = { /*TODO*/ }) {
						  Icon(
							  imageVector = Icons.Rounded.MoreVert,
							  contentDescription = "More Info Icon")
					  }
				  }else Box(){

				  }

		},
		navigationIcon = {
						 if (icon != null) {
							 Icon(
								 imageVector = Icons.Default.ArrowBack,
								 contentDescription = "Arrow Back Icon",
							    tint = MaterialTheme.colors.onSecondary,
								 modifier = Modifier
									 .clickable {
										 onButtonClicked.invoke()
									 }
								 )
						 }
		},
		backgroundColor = MaterialTheme.colors.primary,
		elevation = elevation
	)

}