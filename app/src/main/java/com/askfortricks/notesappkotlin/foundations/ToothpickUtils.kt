package com.askfortricks.notesappkotlin.foundations

import com.askfortricks.notesappkotlin.notes.INoteModel
import com.askfortricks.notesappkotlin.notes.NoteLocalModel
import com.askfortricks.notesappkotlin.tasks.ITaskModel
import com.askfortricks.notesappkotlin.tasks.TaskLocalModel
import toothpick.Toothpick
import toothpick.config.Module

//object defines that ApplicationScope is singleton
object ApplicationScope {
    val scope=Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }

}

object ApplicationModule:Module(){
    init {
        bind(INoteModel::class.java).toInstance(NoteLocalModel())
        bind(ITaskModel::class.java).toInstance(TaskLocalModel())
    }
}