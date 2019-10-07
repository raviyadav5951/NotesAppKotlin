package com.askfortricks.notesappkotlin.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.models.Task
import toothpick.Toothpick
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskListViewContract {

    //changed after toothpick
    //private val model: TaskModel = TaskModel()
    //this will include TaskModel as dependency without new or constructor
    @Inject
    lateinit var model:TaskModel
    //step 1
    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()

    //its not mutable that's why we are accessing it from frag.

    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    //Step2 :init will be callled just after the constreuctor
    init {
        //First open the scope.
        val scope=Toothpick.openScope(this)//we can use any name
        Toothpick.inject(this,scope)

        //post value async performs operation
        _taskListLiveData.postValue(model.getFakeData())
    }


    override fun onToDoCompleted(taskIndex: Int, todoIndex: Int, isCompleted: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isCompleted
    }

}