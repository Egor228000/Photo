package com.example.nastya_app.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nastya_app.Chat
import com.example.nastya_app.Chats
import com.example.nastya_app.Glav
import com.example.nastya_app.Login
import com.example.nastya_app.Menu
import com.example.nastya_app.Plus
import com.example.nastya_app.Profile
import com.example.nastya_app.R
import com.example.nastya_app.Register
import com.example.nastya_app.Search
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.EaseInCirc
import androidx.compose.animation.core.EaseInElastic
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.EaseOutCirc
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import com.example.nastya_app.Images


@Composable
fun MenuGraph(navController: NavHostController) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (currentRoute == "menu" || currentRoute == "search" || currentRoute == "plus" || currentRoute == "chats" || currentRoute == "profile") {
                BottomNavigation(backgroundColor = Color.White) {
                    BottomNavigationItem(
                        selected = currentRoute == "menu",
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.Black,
                        onClick = { navController.navigate("menu") },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.home),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        },
                    )
                    BottomNavigationItem(
                        selected = currentRoute == "search",
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.Black,
                        onClick = { navController.navigate("search") },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        },
                    )
                    BottomNavigationItem(
                        selected = currentRoute == "plus",
                        onClick = { navController.navigate("plus") },
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.plus),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        },
                    )
                    BottomNavigationItem(
                        selected = currentRoute == "chats",
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.Black,
                        onClick = { navController.navigate("chats") },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.chats),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        },
                    )
                    BottomNavigationItem(
                        selected = currentRoute == "profile",
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.Black,
                        onClick = { navController.navigate("profile") },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        },
                    )
                }
            } else {

            }
        }) { padding ->
        NavHost(

            navController = navController,
            startDestination = "register",
            Modifier.padding(padding),
            enterTransition = { EnterTransition.None},
            exitTransition = {ExitTransition.None}
        ) {
            composable("glav") {
                Glav(navController)
            }
            composable("login",
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }) {
                Login(navController)
            }
            composable("register",
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }) {
                Register(navController)
            }


            composable("menu") {
                Menu(navController = navController)

            }
            composable("search") {
                Search(navController = navController)

            }
            composable("image/{kartinka}",
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideOutOfContainer(
                        animationSpec = tween(300, easing = EaseOut),
                        towards = AnimatedContentTransitionScope.SlideDirection.End
                    )
                },
                arguments = listOf(
                    navArgument("kartinka") { type = NavType.StringType },
                )
            ) { backStackEntry ->
                val kartinka = backStackEntry.arguments?.getString("kartinka") ?: ""

                Images(navController = navController, kartinka)
            }
            composable("plus") {
                Plus(navController = navController)
            }

            composable("profile") {
                Profile(navController = navController)
            }
            composable("chats") {
                Chats(navController = navController)
            }

            composable("chat/{avatar}/{name}/{dis}",
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideOutOfContainer(
                        animationSpec = tween(300, easing = EaseOut),
                        towards = AnimatedContentTransitionScope.SlideDirection.End
                    )
                },
                arguments = listOf(
                    navArgument("avatar") { type = NavType.IntType },
                    navArgument("name") { type = NavType.StringType },
                    navArgument("dis") { type = NavType.StringType }
                )) { backStackEntry ->
                val avatar = backStackEntry.arguments?.getInt("avatar") ?: 0
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val dis = backStackEntry.arguments?.getString("dis") ?: ""
                Chat(navController = navController, avatar, name, dis)
            }
        }
    }
}






