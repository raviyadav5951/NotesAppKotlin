package com.askfortricks.notesappkotlin.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.foundations.BaseRecyclerAdapter
import com.askfortricks.notesappkotlin.models.Task
import com.askfortricks.notesappkotlin.views.TaskView
import com.askfortricks.notesappkotlin.views.TodoView
import kotlinx.android.synthetic.main.item_task.view.*


//Created mutable list of task list
class TaskAdapter(taskList: MutableList<Task> = mutableListOf()) :
    BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_task,
                parent,
                false
            )
        )

    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }
}