package com.alemicode.bitcoindemoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.alemicode.bitcoindemoapp.ui.theme.BitcoinDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BitcoinDemoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    // TODO It's better to use viewModel in its graph but because we have one VM for simplicity we intiliaze it in acitivty
                    val mainViewModel: MainViewModel by viewModels()
                    AppNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        mainViewModel = mainViewModel
                    )
                }
            }
        }
    }
}

