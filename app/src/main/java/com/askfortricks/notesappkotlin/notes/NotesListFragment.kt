package com.askfortricks.notesappkotlin.notes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    companion object {

        fun newInstance()=NotesListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager=LinearLayoutManager(context)

        val notesAdapter=NotesAdapter(
            mutableListOf(
                Note("Note one"),
                Note("Note two")
            )
        )
        recyclerView.adapter=notesAdapter
    }
}
