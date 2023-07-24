package com.example.scariofolds.zaDrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Drawer(
    items: List<DrawerItems>,
    navController: NavController,
    onContentClick: (DrawerItems) -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val backStackEntry = navController.currentBackStackEntryAsState()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { 
            ModalDrawerSheet (drawerTonalElevation = 6.dp)
            {

                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    val selected = item.route == backStackEntry.value?.destination?.route
                    NavigationDrawerItem(
                        label = {Text(item.name)},
                        selected = selected,
                        onClick = {
                            scope.launch { drawerState.close() }
                            onContentClick(item) },
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom

            ) {

                Button(onClick = {scope.launch { drawerState.open() } }) {
                    Text(text = "Open Drawer")
                }
            }
        }
    )
}