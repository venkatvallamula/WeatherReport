package uk.co.niceagency.testexercice.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LocationText {

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("status")
    @Expose
    var status: String? = null

}


