package uk.co.niceagency.testexercice.service

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uk.co.niceagency.testexercice.service.DBContract.LocationEntry.Companion.COLUMN_NAME
import uk.co.niceagency.testexercice.service.DBContract.LocationEntry.Companion.TABLE_NAME
import uk.co.niceagency.testexercice.model.Location

class SqliteDatabase(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }
    fun addName(location: Location) {
        val db1=readableDatabase
        val cursor = db1.rawQuery("SELECT * FROM $TABLE_NAME", null)
        
        val values = ContentValues()
        values.put(COLUMN_NAME, location.locationName)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
    fun getAllName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "Location.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DBContract.LocationEntry.TABLE_NAME + " (" +
                        DBContract.LocationEntry.ID + " TEXT PRIMARY KEY," +
                        DBContract.LocationEntry.COLUMN_NAME + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.LocationEntry.TABLE_NAME
    }
}