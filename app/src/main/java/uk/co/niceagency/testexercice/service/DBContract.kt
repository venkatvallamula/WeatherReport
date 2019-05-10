package uk.co.niceagency.testexercice.service

import android.provider.BaseColumns

object DBContract {

    /* Inner class that defines the table contents */
    class LocationEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "locations"
            val ID = "id"
            val COLUMN_NAME = "name"

        }
    }
}