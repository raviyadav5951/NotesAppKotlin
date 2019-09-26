package com.askfortricks.notesappkotlin.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.foundations.BaseRecyclerAdapter
import com.askfortricks.notesappkotlin.models.Task
import com.askfortricks.notesappkotlin.navigation.NavigationActivity
import kotlinx.android.synthetic.main.view_add_button.view.*

/**
 * If-else statement and switch return in kotlin
 */

//Created mutable list of task list
class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf(),
    val touchActionDelegate: TaskListFragment.TouchActionDelegate
) :
    BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == TYPE_ADD_BUTTON) {
            AddButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_add_button,
                    parent,
                    false
                )
            )
        } else {
            TaskViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_task,
                    parent,
                    false
                )
            )
        }


    class TaskViewHolder(view: View) : BaseRecyclerAdapter.BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            (view as com.askfortricks.notesappkotlin.views.TaskView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {

        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)
            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAG_VALUE_TASK)
            }
        }
    }



}