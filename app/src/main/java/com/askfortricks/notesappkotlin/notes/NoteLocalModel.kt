package com.askfortricks.notesappkotlin.notes

import com.askfortricks.notesappkotlin.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel{
    override fun addNote(note: Note, callback: successCallback) {
    }

    override fun updateNote(note: Note, callback: successCallback) {
    }

    override fun deleteNote(note: Note, callback: successCallback) {
    }

    override fun retrieveNotes(): MutableList<Note> = mutableListOf()

    override fun getFakeData(): MutableList<Note> =
        mutableListOf(
            Note("Note one"),
            Note("Note two")
        )

}