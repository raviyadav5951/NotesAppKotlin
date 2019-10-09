package com.askfortricks.notesappkotlin.notes

import com.askfortricks.notesappkotlin.models.Note
typealias successCallback=(Boolean)->Unit

interface INoteModel {
    //CRUD

    fun addNote(note: Note,callback:successCallback)
    fun updateNote(note: Note,callback:successCallback)
    fun deleteNote(note: Note,callback:successCallback)
    fun retrieveNotes():List<Note>

    fun getFakeData(): MutableList<Note>
}