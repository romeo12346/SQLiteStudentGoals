package com.example.sqlitestudentgoals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GoalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goaldetail)

        val txtgoaltitle: TextView = findViewById(R.id.txtgoaltitle)
        val txtgoaldesc: TextView = findViewById(R.id.txtgoaldesc)
        val txtgoaldstatus: TextView = findViewById(R.id.txtgoaldstatus)
        val btnmark: Button = findViewById(R.id.btnaccesssettings)

        btnmark.setOnClickListener(){
        }
    }
}