package com.askfortricks.notesappkotlin.navigation

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.askfortricks.notesappkotlin.R
import com.askfortricks.notesappkotlin.create.CreateActivity
import com.askfortricks.notesappkotlin.notes.NotesListFragment
import com.askfortricks.notesappkotlin.tasks.TaskListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class NavigationActivity : AppCompatActivity(), TaskListFragment.TouchActionDelegate,
    NotesListFragment.TouchActionDelegate {
    companion object {
        const val FRAG_TYPE_KEY = "f_t_k"
        const val FRAG_VALUE_NOTES = "f_v_n"
        const val FRAG_VALUE_TASK = "f_v_t"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        val navView = findViewById<BottomNavigationView>(R.id.navigationView)
        replaceFragment(TaskListFragment.newInstance())
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener = OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.navigation_notes -> {
                replaceFragment(NotesListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_tasks -> {
                replaceFragment(TaskListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHolder, fragment).commit()
    }


    override fun onAddButtonClicked(value: String) {
        gotoCreateActivity(value)
    }


    private fun gotoCreateActivity(fragValue: String) {
        startActivity(Intent(this, CreateActivity::class.java).apply {
            putExtra(FRAG_TYPE_KEY, fragValue)
        })
    }
}
