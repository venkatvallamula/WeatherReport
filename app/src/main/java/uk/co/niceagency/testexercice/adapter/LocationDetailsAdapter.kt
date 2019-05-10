package uk.co.niceagency.testexercice.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.location_item_list.view.*
import uk.co.niceagency.testexercice.R
import uk.co.niceagency.testexercice.model.LocationDeatails
import uk.co.niceagency.testexercice.view.LocationViewActivity
import uk.co.niceagency.testexercice.view.MainActivity

class LocationDetailsAdapter(private val context: LocationViewActivity, private val locationList: ArrayList<LocationDeatails>):
        RecyclerView.Adapter<LocationDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.location_item_list, parent, false))
    }
    override fun getItemCount(): Int {
        return locationList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvDays?.text = locationList.get(position).locationName.toString()
        Log.d("aaaaaaaaaaaa",locationList.get(position).locationName.toString())
    }
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val tvDays =view.tv_days
        val tvTem =view.tv_temp


    }
}