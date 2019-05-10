package uk.co.niceagency.testexercice.model

class LocationDeatails {
    var id: Int = 0
    var locationName: String? = null
    constructor(id: Int, locationName: String) {
        this.id = id
        this.locationName = locationName
    }
    constructor(locationName: String) {
        this.locationName = locationName
    }
}