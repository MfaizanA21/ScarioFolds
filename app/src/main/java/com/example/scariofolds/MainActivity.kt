package com.example.scariofolds

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.scariofolds.ui.theme.ScarioFoldsTheme
import com.example.scariofolds.zaBottomBar.BottomNavItem
import com.example.scariofolds.zaBottomBar.BottomNavigationBar
import com.example.scariofolds.zaBottomBar.Navigation
import com.example.scariofolds.zaDrawer.Drawer
import com.example.scariofolds.zaDrawer.DrawerItems

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScarioFoldsTheme {
                ScaffoldDemo()
                Draar()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDemo() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "home",
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        name = "Chat",
                        route = "chat",
                        icon = Icons.Default.Notifications,
                        badgeCount = 23
                    ),
                    BottomNavItem(
                        name = "Settings",
                        route = "settings",
                        icon = Icons.Default.Settings
                    ),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        },
        topBar = { AppBar() },
        ){
        Navigation(navController = navController)
    }
}

@Composable
fun Draar() {
    val navController = rememberNavController()
    Drawer(
        items = listOf(
            DrawerItems(
                name = "Go to Home",
                icon = Icons.Default.Home,
                route = "home"
            ),
            DrawerItems(
                name = "Go to Chats",
                icon = Icons.Default.Notifications,
                route = "chat"
            ),
            DrawerItems(
                name = "Go to Settings",
                icon = Icons.Default.Settings,
                route = "settings"
            )),
        navController = navController,
        onContentClick = {
            navController.navigate(it.route)
        }
    )
}


@Preview(showBackground = true, device = "id:pixel_3")
@Composable
fun GreetingPreview() {
    ScarioFoldsTheme {
        ScaffoldDemo()
        Draar()
    }
}