package uk.co.niceagency.testexercice.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import uk.co.niceagency.testexercice.R

import kotlinx.android.synthetic.main.activity_location_view.*
import uk.co.niceagency.testexercice.adapter.LocationDetailsAdapter
import uk.co.niceagency.testexercice.model.LocationDeatails
import uk.co.niceagency.testexercice.service.ApiServices

class LocationViewActivity : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LocationDetailsAdapter
    var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_view)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);
        val subTitle:TextView = findViewById(R.id.toolbar_sub_title)
        val locationList = ArrayList<LocationDeatails>()
        recyclerView = findViewById(R.id.recycler_view_location)
        layoutManager = LinearLayoutManager(this)
        layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        recyclerView.layoutManager = layoutManager
        adapter = LocationDetailsAdapter(this,locationList)
        recyclerView.adapter = adapter
        val cityName:String = intent.getStringExtra("cityName")
        subTitle?.text=cityName
        beginSearch(cityName,"5","b1b15e88fa797225412429c1c50c122a1")


    }
    private fun beginSearch(cityName: String,lang:String,appid:String) {
        val apiServices=ApiServices.create()
       disposable = apiServices.search(cityName, lang, appid)
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
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()
        when (id) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
