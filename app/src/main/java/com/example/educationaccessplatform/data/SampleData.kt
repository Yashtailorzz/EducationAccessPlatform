package com.example.educationaccessplatform.data

object SampleData {
    val units = listOf(
        Unit(
            name = "Introduction to the Course",
            lessons = listOf(
                Lesson("Week 1 - Course Outline", "Overview and expectations"),
                Lesson("Assignment 1", "Group project in thematic areas")
            )
        ),
        Unit(
            name = "Kotlin Basics",
            lessons = listOf(
                Lesson("Week 2 - Kotlin Syntax", "Operators, data types, null safety"),
                Lesson("Week 3 - Functions", "Parameters, return types, and function calls"),
                Lesson("Week 4 - Classes and Objects", "OOP in Kotlin")
            )
        ),
        Unit(
            name = "Android Development",
            lessons = listOf(
                Lesson("Week 6 - Layouts", "Linear, Relative, Constraint layouts"),
                Lesson("Week 7 - Navigation", "Intents and activities"),
                Lesson("Week 8 - Lifecycle & UI Architecture", "State and fragments")
            )
        )
    )
}
