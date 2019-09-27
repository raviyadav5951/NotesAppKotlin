package com.askfortricks.notesappkotlin.tasks

interface TaskListViewContract {

    fun onToDoCompleted(taskIndex:Int,todoIndex:Int,isCompleted:Boolean)
}