package com.example.educationaccessplatform

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationaccessplatform.ui.theme.EducationAccessPlatformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAccessPlatformTheme {
                MainScreen(
                    onLessonsClick = {
                        startActivity(Intent(this, LessonsActivity::class.java))
                    },
                    onAboutClick = {
                        startActivity(Intent(this, AboutActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(onLessonsClick: () -> Unit, onAboutClick: () -> Unit) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onLessonsClick() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SELECT PROGRAM")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onAboutClick() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("About App")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    EducationAccessPlatformTheme {
        MainScreen(onLessonsClick = {}, onAboutClick = {})
    }
}
