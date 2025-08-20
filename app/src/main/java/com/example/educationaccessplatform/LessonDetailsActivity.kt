package com.example.educationaccessplatform

import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.educationaccessplatform.ui.theme.EducationAccessPlatformTheme
import com.example.educationaccessplatform.ui.components.AppTopBar

class LessonDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lessonTitle = intent.getStringExtra("lessonTitle") ?: "Lesson Details"
        val lessonDescription = intent.getStringExtra("lessonDescription") ?: ""

        setContent {
            EducationAccessPlatformTheme {
                LessonDetailsScreen(
                    title = lessonTitle,
                    description = lessonDescription
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // needed for TopAppBar
@Composable
fun LessonDetailsScreen(title: String, description: String) {
    Scaffold(
        topBar = { AppTopBar(title = "Select Program", showBackButton = false) }
    ) { innerPadding ->
        Text(
            text = description,
            modifier = Modifier.padding(innerPadding).padding(16.dp)
        )
    }
}
