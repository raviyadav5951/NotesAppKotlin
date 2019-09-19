package com.askfortricks.notesappkotlin.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.askfortricks.notesappkotlin.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) :
    ConstraintLayout(context, attrs, defStyleAttr) {


    fun initView(todo: Todo,callback:(()->Unit)?=null) {

        descriptionView.text = todo.description
        completeCheckBox.isChecked = todo.isComplete

        if (todo.isComplete) {
            descriptionView.paintFlags =
                descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
        setUpCheckedStateListener(todo,callback)

    }

    /**
     * We have passed a function as a parameter which is invoked on each time checkbox is check/uncheck
     */
    private fun setUpCheckedStateListener(todo:Todo,callback:(()->Unit)?=null) {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            todo.isComplete=isChecked
            callback?.invoke() //invoke the function on check/uncheck
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikeThrough()
            }
        }
    }

    private fun createStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        descriptionView.apply {
          paintFlags=  paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv();
        }
    }
}
