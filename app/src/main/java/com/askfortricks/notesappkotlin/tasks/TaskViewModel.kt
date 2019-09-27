package com.askfortricks.notesappkotlin.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.models.Task
import com.askfortricks.notesappkotlin.models.Todo

class TaskViewModel : ViewModel(),TaskListViewContract {

    //step 1
    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()

    //its not mutable that's why we are accessing it from frag.

    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    //Step2 :init will be callled just after the constreuctor
    init {
        //post value async performs operation
        _taskListLiveData.postValue(getFakeData())
    }

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

    override fun onToDoCompleted(taskIndex: Int, todoIndex: Int, isCompleted: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete=isCompleted
    }

}