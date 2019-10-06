package com.askfortricks.notesappkotlin.notes


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.askfortricks.notesappkotlin.R

class NotesListFragment : Fragment(), NotesListViewContract {

    lateinit var touchActionDelegate: TouchActionDelegate
    lateinit var noteViewModel: NoteViewModel
    lateinit var contentView: NotesListView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.let { context ->
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
        return inflater.inflate(R.layout.fragment_notes_list, container, false).apply {
            contentView=this as NotesListView
        }
    }

    companion object {

        fun newInstance() = NotesListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setContentView()
    }

    private fun setContentView() {

        contentView.initView(touchActionDelegate, noteViewModel)
    }

    private fun bindViewModel() {
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.noteLiveData.observe(this, Observer { notelist ->
            contentView.updateList(notelist)
        })
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }
}
