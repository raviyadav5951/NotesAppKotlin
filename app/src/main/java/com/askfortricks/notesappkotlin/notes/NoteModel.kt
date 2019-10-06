package com.askfortricks.notesappkotlin.notes

import com.askfortricks.notesappkotlin.models.Note

class NoteModel {

    fun getFakeData(): MutableList<Note> =
        mutableListOf(
            Note("Note one"),
            Note("Note two")
        )

}