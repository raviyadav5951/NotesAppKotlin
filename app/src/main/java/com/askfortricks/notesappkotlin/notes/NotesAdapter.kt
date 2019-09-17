package com.askfortricks.notesappkotlin.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.foundations.BaseRecyclerAdapter
import com.askfortricks.notesappkotlin.models.Note
import com.askfortricks.notesappkotlin.views.NoteView

class NotesAdapter(notesList: MutableList<Note> = mutableListOf()) :
    BaseRecyclerAdapter<Note>(notesList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note) {
            (view as NoteView).initView(data)
        }
    }
}