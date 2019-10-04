package com.askfortricks.notesappkotlin.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.foundations.BaseRecyclerAdapter
import com.askfortricks.notesappkotlin.models.Note
import com.askfortricks.notesappkotlin.navigation.NavigationActivity
import com.askfortricks.notesappkotlin.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NotesAdapter(
    notesList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
) :
    BaseRecyclerAdapter<Note>(notesList) {


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
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_note,
                    parent,
                    false
                )
            )
        }


    class ViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note, position: Int) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit, position: Int) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)
            view.buttonText.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAG_VALUE_NOTES)
            }
        }

    }
}