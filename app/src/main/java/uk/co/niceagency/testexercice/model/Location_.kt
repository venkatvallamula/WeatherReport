package uk.co.niceagency.testexercice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location_ {

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lng")
    @Expose
    var lng: Double? = null

}
