package com.askfortricks.notesappkotlin.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.askfortricks.notesappkotlin.models.Task
import kotlinx.android.synthetic.main.fragment_task_list.view.*

class TaskListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var adapter: TaskAdapter
    private lateinit var touchActionDelegate: TaskListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: TaskListViewContract


    fun initView(
        taDelegate: TaskListFragment.TouchActionDelegate,
        daDelegate: TaskListViewContract
    ) {

        setDelegate(taDelegate, daDelegate)
        setUpView()
    }

    private fun setDelegate(
        taDelegate: TaskListFragment.TouchActionDelegate,
        daDelegate: TaskListViewContract
    ) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daDelegate
    }

    private fun setUpView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(
            touchActionDelegate = touchActionDelegate
        )
        recyclerView.adapter = adapter
    }

    fun updateList(list: List<Task>) {
        adapter.updateList(list)
    }

}