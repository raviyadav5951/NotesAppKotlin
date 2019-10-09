package com.askfortricks.notesappkotlin.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.askfortricks.notesappkotlin.foundations.ApplicationScope
import com.askfortricks.notesappkotlin.models.Note
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel : ViewModel(), NotesListViewContract {

    //changed after toothpick
    //private val localModel: NoteLocalModel = NoteLocalModel()
    @Inject
    lateinit var localModel:INoteModel
    private val _noteLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteLiveData: LiveData<MutableList<Note>> = _noteLiveData


    init {
        //before moving to singleton ApplicationScope
//        val scope=Toothpick.openScope(this)
//        scope.installModules(Module().apply {
//            bind(INoteModel::class.java).toInstance(NoteLocalModel())
//        }
//        )
//        Toothpick.inject(this,scope)

        //we made ApplicationScope as singleton and added all module and bindings there

        Toothpick.inject(this,ApplicationScope.scope)

        //post value async performs operation
        _noteLiveData.postValue(localModel.getFakeData())
    }


}