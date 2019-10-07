package com.askfortricks.notesappkotlin.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var task: Task

    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit) {
        this.task = task
        titleView.text = task.title
        task.todos.forEachIndexed { todoIndex, todo ->
            val todoView = (LayoutInflater.from(context).inflate(
                R.layout.view_todo,
                todoContainer,
                false
            ) as TodoView).apply {
                initView(todo) { isChecked ->
                    todoCheckedCallback.invoke(todoIndex, isChecked)
                    if (isTaskComplete()) {
                        //differentiate between current this (TodoView )and this (TASK view)
                        //our titleview is inside taskview
                        this@TaskView.titleView.setStrikeThrough()
                    } else {
                        this@TaskView.titleView.removeStrikeThrough()
                    }
                }
            }
            todoContainer.addView(todoView)


        }
    }

    private fun isTaskComplete(): Boolean = task.todos.none { todo ->
        !todo.isComplete
    }




}