package uk.co.niceagency.testexercice.view

import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_location.*
import uk.co.niceagency.testexercice.R
import uk.co.niceagency.testexercice.service.SqliteDatabase
import uk.co.niceagency.testexercice.model.Location

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        val cityName:EditText = findViewById(R.id.edit_city);
        val save_image:ImageView = findViewById(R.id.image_done)
        cityName.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {

                true
            }
            false
        }
        save_image.setOnClickListener {
            if (!cityName.text.toString().equals("")) {
                val dbHandler = SqliteDatabase(this)
                val user = Location(cityName.text.toString())
                dbHandler.addName(user)
                Toast.makeText(this, "Add record", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "enter city name", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()
        when (id) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
