package com.askfortricks.notesappkotlin.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.models.Note

class NoteViewModel : ViewModel(), NotesListViewContract {

    private val model: NoteModel = NoteModel()
    private val _noteLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteLiveData: LiveData<MutableList<Note>> = _noteLiveData


    init {
        //post value async performs operation
        _noteLiveData.postValue(model.getFakeData())
    }


}