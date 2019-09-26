package com.askfortricks.notesappkotlin.tasks


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.askfortricks.notesappkotlin.R
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {

    lateinit var taskViewModel: TaskViewModel
    lateinit var touchActionDelegate: TouchActionDelegate
    lateinit var adapter : TaskAdapter

    companion object {
        fun newInstance() = TaskListFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context?.let { context ->
            if (context is TouchActionDelegate) {
                touchActionDelegate = context
            }
        }
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
        adapter = TaskAdapter(
            touchActionDelegate = touchActionDelegate
        )
        recyclerView.adapter = adapter
        bindViewModel()
    }

    //Step 3 : create observer
    private fun bindViewModel() {
        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        taskViewModel.taskListLiveData.observe(this, Observer{
            tasklist->adapter.updateList(tasklist)
        })
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}
