package com.example.educationaccessplatform

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.educationaccessplatform.data.SampleData
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack


class UnitLessonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val unitName = intent.getStringExtra("unitName")
        val unit = SampleData.units.find { it.name == unitName }

        setContent {
            unit?.let {
                LessonsListScreen(
                    unitName = it.name,
                    lessons = it.lessons
                ) { lesson ->
                    val intent = Intent(this, LessonDetailsActivity::class.java)
                    intent.putExtra("lessonTitle", lesson.title)
                    intent.putExtra("lessonDescription", lesson.description) // ✅ key matches now
                    startActivity(intent)
                }
            } ?: run {
                Text("Unit not found")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonsListScreen(
    unitName: String,
    lessons: List<com.example.educationaccessplatform.data.Lesson>,
    onLessonClick: (com.example.educationaccessplatform.data.Lesson) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(unitName) },
                navigationIcon = { // ✅ Back button
                    IconButton(onClick = { /* close screen */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(lessons.size) { index ->
                val lesson = lessons[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { onLessonClick(lesson) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(lesson.title, style = MaterialTheme.typography.titleMedium)
                        Text(lesson.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
