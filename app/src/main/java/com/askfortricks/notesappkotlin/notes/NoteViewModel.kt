package com.askfortricks.notesappkotlin.notes

import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.models.Note

class NoteViewModel : ViewModel() {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Note one"),
        Note("Note two")
    )
}