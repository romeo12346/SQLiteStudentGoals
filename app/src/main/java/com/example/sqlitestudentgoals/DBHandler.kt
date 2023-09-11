package com.example.sqlitestudentgoals

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context, factory: SQLiteDatabase.CursorFactory?) :
SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
       val query = ("CREATE TABLE " +  TABLE_NAME + " ( id INTEGER PRIMARY KEY AUTOINCREMENT," + Title_Col + " TEXT," + Desc_Col +" TEXT, is_completed INTEGER DEFAULT 0 );")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addGoal(title : String, description : String ){

        val values = ContentValues()

        values.put(Title_Col, title)
        values.put(Desc_Col, description)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    fun getGoal(): Cursor? {
        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }
    companion object{

        private val DATABASE_NAME = "StudentGoals"

        private val DATABASE_VERSION = 1

        val TABLE_NAME = "Goals"

        val Title_Col = "Title"

        val Desc_Col = "Description"

    }

}