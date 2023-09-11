package com.example.sqlitestudentgoals

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsActivity : AppCompatActivity() {

    private var parentView: View? = findViewById(R.id.parentView)
    private var themeSwitch: SwitchMaterial? = findViewById(R.id.themeSwitch)
    private var themeTV: TextView? = findViewById(R.id.themeTV)
    private var titleTV: TextView? = findViewById(R.id.titleTV)
    private var settings: UserSettings? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        settings = application as UserSettings
        initWidget()
        loadSharedPreferences()
        initSwitchListener()
    }

    private fun initSwitchListener() {

        themeSwitch?.setOnCheckedChangeListener { _, isChecked ->
            // do whatever you need to do when the switch is toggled here
            if (isChecked) settings!!.customTheme =
                UserSettings.DARK_THEME else settings!!.customTheme =
                UserSettings.LIGHT_THEME
            val editor = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit()
            editor.putString(UserSettings.CUSTOM_THEME, settings!!.customTheme)
            editor.apply()
            updateView()
        }

    }

    private fun loadSharedPreferences() {
        val sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE)
        val theme =
            sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME)
        settings!!.customTheme = theme
        updateView()
    }
    private fun initWidget() {
        themeTV = findViewById(R.id.themeTV)
        titleTV = findViewById(R.id.titleTV)
        themeSwitch = findViewById(R.id.themeSwitch)
        parentView = findViewById(R.id.parentView)
    }
    private fun updateView() {
        val black = ContextCompat.getColor(this, R.color.black)
        val white = ContextCompat.getColor(this, R.color.white)
        if (settings!!.customTheme == UserSettings.DARK_THEME) {
            titleTV!!.setTextColor(white)
            themeTV!!.setTextColor(white)
            themeTV!!.text = "Dark"
            themeSwitch!!.isChecked = true
        } else {
            titleTV!!.setTextColor(black)
            themeTV!!.setTextColor(black)
            themeTV!!.text = "Light"
            themeSwitch!!.isChecked = false
        }
    }
}
