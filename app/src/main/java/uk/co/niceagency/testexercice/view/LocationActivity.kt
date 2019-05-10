package uk.co.niceagency.testexercice.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_location.*
import uk.co.niceagency.testexercice.R
import uk.co.niceagency.testexercice.service.SqliteDatabase
import uk.co.niceagency.testexercice.model.Location
import uk.co.niceagency.testexercice.model.LocationText
import uk.co.niceagency.testexercice.service.ApiServices
import uk.co.niceagency.testexercice.service.ApiServicesLocation

class LocationActivity : AppCompatActivity() {
    var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        val cityName:EditText = findViewById(R.id.edit_city);
        val save_image:ImageView = findViewById(R.id.image_done)
        cityName.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                getCityName(cityName.text.toString())
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
    private fun getCityName(cityName: String) {
        val apiServices= ApiServicesLocation.create()
        disposable = apiServices.getCity(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> Log.d("result..",result.toString()) },
                        { error -> Log.d("Error..",error.message) }
                )
    }
    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

}
