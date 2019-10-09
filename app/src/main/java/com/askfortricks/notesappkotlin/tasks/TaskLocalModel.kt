package com.askfortricks.notesappkotlin.tasks

import com.askfortricks.notesappkotlin.models.Task
import com.askfortricks.notesappkotlin.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor(): ITaskModel{
    override fun getFakeData(): MutableList<Task> = mutableListOf(
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

    override fun addTask(Task: Task, callback: successCallback) {
    }

    override fun updateTask(Task: Task, callback: successCallback) {
    }

    override fun deleteTask(Task: Task, callback: successCallback) {
    }

    override fun retrieveTasks(): List<Task> = mutableListOf()


}