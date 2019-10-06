package com.askfortricks.notesappkotlin.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.models.Task

class TaskViewModel : ViewModel(), TaskListViewContract {

    private val model: TaskModel = TaskModel()
    //step 1
    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()

    //its not mutable that's why we are accessing it from frag.

    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    //Step2 :init will be callled just after the constreuctor
    init {
        //post value async performs operation
        _taskListLiveData.postValue(model.getFakeData())
    }


    override fun onToDoCompleted(taskIndex: Int, todoIndex: Int, isCompleted: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isCompleted
    }

}