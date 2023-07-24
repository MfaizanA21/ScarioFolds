package com.example.scariofolds

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.scariofolds.ui.theme.PurpleGrey40
import com.example.scariofolds.ui.theme.PurpleGrey80
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    val scaffoldState= rememberDrawerState(initialValue =DrawerValue.Closed )
    val coroutineScope= rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(
                text = "AppBar",
                color = PurpleGrey40,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        },
//        actions = { Icon(imageVector = Icons.Default.List, contentDescription = null) },
        navigationIcon = { IconButton(onClick = { coroutineScope.launch {   scaffoldState.open()}}) {
            
         Icon(imageVector = Icons.Default.Menu, contentDescription = null)} },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = PurpleGrey80
        )
    )
}
