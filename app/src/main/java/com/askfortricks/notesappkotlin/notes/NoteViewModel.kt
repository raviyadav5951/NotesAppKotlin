package com.askfortricks.notesappkotlin.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.models.Note
import toothpick.Toothpick
import javax.inject.Inject

class NoteViewModel : ViewModel(), NotesListViewContract {

    //changed after toothpick
    //private val model: NoteModel = NoteModel()
    @Inject
    lateinit var model:NoteModel
    private val _noteLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteLiveData: LiveData<MutableList<Note>> = _noteLiveData


    init {
        val scope=Toothpick.openScope(this)
        Toothpick.inject(this,scope)

        //post value async performs operation
        _noteLiveData.postValue(model.getFakeData())
    }


}