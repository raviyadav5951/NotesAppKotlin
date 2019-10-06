package com.askfortricks.notesappkotlin.tasks

import com.askfortricks.notesappkotlin.models.Task
import com.askfortricks.notesappkotlin.models.Todo

class TaskModel {

    fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Test one", mutableListOf(
                Todo("testing One"),
                Todo("testing One One", true)
            )
        ),
        Task(
            "Test two",
            mutableListOf(
                Todo("testing two", true),
                Todo("testing two two")
            )
        ),
        Task(
            "Test three",
            mutableListOf(
                Todo("test A !"),
                Todo("test B !")
            )
        )
    )
}