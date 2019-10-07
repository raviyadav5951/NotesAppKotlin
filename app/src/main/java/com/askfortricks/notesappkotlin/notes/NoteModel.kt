package com.askfortricks.notesappkotlin.notes

import com.askfortricks.notesappkotlin.models.Note
import javax.inject.Inject

class NoteModel @Inject constructor(){

    fun getFakeData(): MutableList<Note> =
        mutableListOf(
            Note("Note one"),
            Note("Note two")
        )

}