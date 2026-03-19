package com.example.lazyapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazyapp.ui.theme.LazyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyAppScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LazyAppScreen(modifier: Modifier = Modifier) {
    if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
        LazyAppColumn(modifier)
    } else {
        LazyAppRow(modifier)
    }
}

@Composable
fun LazyAppColumn(modifier: Modifier){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        items(4){ index ->
            Image(
                painter = painterResource(R.drawable.kittens),
                contentDescription = "Kittens together",
                modifier = Modifier.padding(top = 50.dp, start = 12.dp)
            )
            Text("Image: $index")
        }
    }
}

@Composable
fun LazyAppRow(modifier:  Modifier){
    LazyRow(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
    ) {
        items(3){ index ->
            Image(
                painter = painterResource(R.drawable.kittens),
                contentDescription = "Kittens together",
                modifier = Modifier.padding(end = 10.dp, start = 20.dp, top = 40.dp)
            )
        }
    }
}