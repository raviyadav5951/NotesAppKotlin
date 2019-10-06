package com.askfortricks.notesappkotlin.models

data class Task(
    var title: String,
    val todos: MutableList<Todo> = mutableListOf(),
    var tag: Tag? = null
)

data class Todo(
    var description: String,
    var isComplete: Boolean = false
)

data class Tag(
    val name: String,
    val colourResId: Int
)

data class Note(
    var description: String,
    var tag: Tag? = null
)