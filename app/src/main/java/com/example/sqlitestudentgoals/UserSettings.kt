package com.example.sqlitestudentgoals

class UserSettings {
     var  customTheme: String? = null

    companion object {
        const val PREFERENCES = "preferences"
        const val CUSTOM_THEME = "customTheme"
        const val LIGHT_THEME = "lightTheme"
        const val DARK_THEME = "darkTheme"
    }
}