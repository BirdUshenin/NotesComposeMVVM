package com.mrbirds.notescomposemvvm.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.mrbirds.notescomposemvvm.MainViewModel
import com.mrbirds.notescomposemvvm.MainViewModelFactory
import com.mrbirds.notescomposemvvm.navigation.NavRoute
import com.mrbirds.notescomposemvvm.ui.theme.NotesComposeMVVMTheme
import com.mrbirds.notescomposemvvm.utils.TYPE_DATABASE
import com.mrbirds.notescomposemvvm.utils.TYPE_FIREBASE
import com.mrbirds.notescomposemvvm.utils.TYPE_ROOM

@Composable
fun StartScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    Scaffold(modifier = Modifier.fillMaxSize()
    ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "What will me use?")
        Button(
            onClick = {
                mViewModel.initDatabase(TYPE_ROOM)
                navController.navigate(route = NavRoute.Main.route)},
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)
        ){
            Text(text = "Room dataBase")
        }

        Button(
            onClick = {
                mViewModel.initDatabase(TYPE_FIREBASE)
                navController.navigate(route = NavRoute.Main.route)},
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)
        ){
            Text(text = "FireBase dataBase")
        }

      }
    }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    NotesComposeMVVMTheme {
        StartScreen(navController = rememberNavController())
    }
}