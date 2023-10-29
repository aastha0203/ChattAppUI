package com.example.uigossip.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uigossip.Screens.ChatScreen
import com.example.uigossip.Screens.HomeScreen
import com.example.uigossip.Screens.StartScreen
import com.example.uigossip.data.Person

@Composable
fun ChatNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Start_Screen) {
        composable(Start_Screen) {
            StartScreen(){
                navHostController.navigate(Home_Screen)
            }
        }
        composable(Chat_Screen) {
            val data = navHostController.previousBackStackEntry?.savedStateHandle?.get<Person>("data") ?: Person()
            ChatScreen(person = data)
        }
        composable(Home_Screen) {
            HomeScreen{
                navHostController.currentBackStackEntry?.savedStateHandle?.set(
                    "data",
                    it
                )
                navHostController.navigate(Chat_Screen)
            }
        }


    }

}


const val Start_Screen = "Start screen"
const val Home_Screen = "Home screen"
const val Chat_Screen = "Chat screen"