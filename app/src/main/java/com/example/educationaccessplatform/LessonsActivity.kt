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

class LessonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitsScreen { unitName ->
                val intent = Intent(this, UnitLessonsActivity::class.java)
                intent.putExtra("unitName", unitName)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun UnitsScreen(onUnitClick: (String) -> Unit) {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(SampleData.units.size) { index ->
                val unit = SampleData.units[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { onUnitClick(unit.name) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(unit.name, style = MaterialTheme.typography.titleMedium)
                        Text("${unit.lessons.size} lessons", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
