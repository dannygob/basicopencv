package com.example.basicopencv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicopencv.ui.theme.BasicOpenCVTheme
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import org.opencv.android.OpenCVLoader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenCVInitializer()
            Greeting(name = "Android")
        }
    }
}

@Composable
fun OpenCVInitializer() {
    val isOpenCVLoaded = remember { OpenCVLoader.initDebug() }

    LaunchedEffect(Unit) {
        if (!isOpenCVLoaded) {
            Log.e("OpenCV", "Error al cargar OpenCV")
        } else {
            Log.d("OpenCV", "OpenCV cargado correctamente")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}