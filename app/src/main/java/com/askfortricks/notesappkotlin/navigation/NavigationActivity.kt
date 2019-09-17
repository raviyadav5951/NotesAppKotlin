package com.askfortricks.notesappkotlin.navigation

import android.os.Bundle

import com.askfortricks.notesappkotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.askfortricks.notesappkotlin.notes.NotesListFragment
import com.askfortricks.notesappkotlin.tasks.TaskListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val navView = findViewById<BottomNavigationView>(R.id.navigationView)
        replaceFragment(TaskListFragment.newInstance())
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener= OnNavigationItemSelectedListener{ menuItem ->
        when(menuItem.itemId){
            R.id.navigation_notes-> {
                replaceFragment(NotesListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_tasks->{
                replaceFragment(TaskListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false

    }

    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHolder,fragment).commit()
    }
}
