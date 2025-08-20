package com.example.educationaccessplatform.data

data class Lesson(
    val title: String,
    val description: String
)

data class Unit(
    val name: String,
    val lessons: List<Lesson>
)

data class Program(
    val name: String,
    val units: List<Unit>
)
