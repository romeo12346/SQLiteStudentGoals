package com.example.sqlitestudentgoals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtgoallist: TextView = findViewById(R.id.txtgoallist)
        val btnnewgoal: Button = findViewById(R.id.btnnewgoal)
        val btnaccesssettings: Button = findViewById(R.id.btnaccesssettings)

        btnnewgoal.setOnClickListener(){
        }
        btnaccesssettings.setOnClickListener(){
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i)
        }
    }
}