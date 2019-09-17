package com.askfortricks.notesappkotlin.tasks


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.models.Task
import com.askfortricks.notesappkotlin.models.Todo
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {

    companion object {
        fun newInstance() = TaskListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(
            mutableListOf(
                Task(
                    "Test one", mutableListOf(
                        Todo("testing One"),
                        Todo("testing One One",true)
                    )
                ),
                Task("Test two",
                    mutableListOf(
                        Todo("testing two",true),
                        Todo("testing two two")
                    ))
            )
        )
        recyclerView.adapter = adapter
    }

}
