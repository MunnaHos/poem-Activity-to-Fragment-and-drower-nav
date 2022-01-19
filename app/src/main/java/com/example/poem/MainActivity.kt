package com.example.poem

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Communicat {

    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var navView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout= findViewById<DrawerLayout>(R.id.drawerLayout)
         navView =findViewById(R.id.nav_view)


        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home ->{
                    Toast.makeText(applicationContext ,"Click Home",Toast.LENGTH_SHORT).show()
                }
        }
            true
    }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun dataPass(edittext: String) {
        val bundle = Bundle()
        bundle.putString("key",edittext)

        val fragmentB = BackFragment()
        val transition = this.supportFragmentManager.beginTransaction()

        fragmentB.arguments= bundle

        transition.replace(R.id.container,fragmentB)
        transition.addToBackStack(null).commit()


        //.addToBackStack(null) -  not destroy app by back button
    }

}