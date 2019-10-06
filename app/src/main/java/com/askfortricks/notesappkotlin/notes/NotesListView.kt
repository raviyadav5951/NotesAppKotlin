package com.askfortricks.notesappkotlin.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.askfortricks.notesappkotlin.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NotesListView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int = 1) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var dataActionDelegate: NotesListViewContract

    fun initView(
        taDelegate: NotesListFragment.TouchActionDelegate,
        daDelegate: NotesListViewContract
    ) {
        setUpDelegates(taDelegate, daDelegate)
        setUpView()
    }

    private fun setUpDelegates(
        taDelegate: NotesListFragment.TouchActionDelegate,
        daDelegate: NotesListViewContract
    ) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daDelegate
    }

    private fun setUpView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        notesAdapter = NotesAdapter(
            touchActionDelegate = touchActionDelegate //named parameter

        )
        recyclerView.adapter = notesAdapter
    }

    fun updateList(list: List<Note>) {
        notesAdapter.updateList(list)
    }
}