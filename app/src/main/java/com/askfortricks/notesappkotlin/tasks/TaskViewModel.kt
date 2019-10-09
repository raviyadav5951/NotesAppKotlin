package com.askfortricks.notesappkotlin.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.foundations.ApplicationScope
import com.askfortricks.notesappkotlin.models.Task
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskListViewContract {

    //changed after toothpick
    //private val localModel: TaskLocalModel = TaskLocalModel()
    //this will include TaskLocalModel as dependency without new or constructor
    @Inject
    lateinit var localModel: ITaskModel
    //step 1
    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()

    //its not mutable that's why we are accessing it from frag.

    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    //Step2 :init will be callled just after the constreuctor
    init {

        //before moving to singleton ApplicationScope
        //First open the scope.
//        val scope = Toothpick.openScope(this)//we can use any name
//        scope.installModules(Module().apply {
//            bind(ITaskModel::class.java).toInstance(TaskLocalModel())
//        }
//        )
//        Toothpick.inject(this, scope)

        //we made ApplicationScope as singleton and added all module and bindings there

        Toothpick.inject(this,ApplicationScope.scope)

        //post value async performs operation
        _taskListLiveData.postValue(localModel.getFakeData())
    }


    override fun onToDoCompleted(taskIndex: Int, todoIndex: Int, isCompleted: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isCompleted
    }

}