package com.mrbirds.notescomposemvvm.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.Text

@Composable
fun Start(navController: NavHostController) {
    Text(text = "Notes App")
}