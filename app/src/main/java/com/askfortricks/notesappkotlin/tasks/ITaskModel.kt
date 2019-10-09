package com.askfortricks.notesappkotlin.tasks

import com.askfortricks.notesappkotlin.models.Task

typealias successCallback=(Boolean)->Unit
interface ITaskModel {
//CRUD

    fun addTask(Task: Task, callback:successCallback)
    fun updateTask(Task: Task, callback:successCallback)
    fun deleteTask(Task: Task, callback:successCallback)
    fun retrieveTasks():List<Task>
    fun getFakeData(): MutableList<Task>
}