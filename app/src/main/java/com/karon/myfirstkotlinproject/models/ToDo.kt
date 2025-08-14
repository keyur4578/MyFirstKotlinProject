package com.karon.myfirstkotlinproject.models

data class ToDo(
    val userId: Long,
    val id: Long,
    val title: String,
    val completed: Boolean,
)