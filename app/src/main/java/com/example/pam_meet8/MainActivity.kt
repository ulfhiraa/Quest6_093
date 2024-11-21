package com.example.pam_meet8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pam_meet8.navigation.Halaman
import com.example.pam_meet8.navigation.MahasiswaApp
import com.example.pam_meet8.ui.screen.CardSection
import com.example.pam_meet8.ui.screen.SplashView
import com.example.pam_meet8.ui.theme.PAM_Meet8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAM_Meet8Theme {
                MahasiswaApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PAM_Meet8Theme {
        Greeting("Android")
    }
}