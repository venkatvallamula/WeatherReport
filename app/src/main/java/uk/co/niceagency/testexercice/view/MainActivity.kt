package uk.co.niceagency.testexercice.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import uk.co.niceagency.testexercice.R


import uk.co.niceagency.testexercice.model.Location
import uk.co.niceagency.testexercice.service.DBContract
import uk.co.niceagency.testexercice.service.SqliteDatabase


class MainActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar);
        val drawer_layout: DrawerLayout = findViewById(R.id.drawer_layout);
        val fab: FloatingActionButton = findViewById(R.id.fab);
        val navigation_view : NavigationView = findViewById(R.id.navigation_view)
        val locationList = initList()
        // Configure action bar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Locations"

        fab.setOnClickListener{
            val intent = Intent(this, LocationActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
        val drawerToggle:ActionBarDrawerToggle = object : ActionBarDrawerToggle(
                this,drawer_layout,toolbar, R.string.drawer_open,
                R.string.drawer_close){
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }
        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawer_layout.closeDrawers()

            // Handle navigation view item clicks here.
            when (menuItem.itemId) {

                R.id.action_setting -> {
                    val settings= Intent(this, Settings::class.java)
                    startActivity(settings)
//                    Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
                }

            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }
    }
    fun initList(): ArrayList<Location> {
        val myList = ArrayList<Location>()
        val dbHandler = SqliteDatabase(this)
        val cursor = dbHandler.getAllName();
        if (cursor != null){
            cursor.moveToFirst()
            while (cursor.moveToNext()){
                val location = Location(cursor.getString(cursor.getColumnIndex(DBContract.LocationEntry.COLUMN_NAME)));
                myList.addAll(listOf(location))
            }
        }
        cursor?.close()
        return myList
    }

}