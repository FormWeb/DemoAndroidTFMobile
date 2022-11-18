package be.bxl.will.demoandroid

import android.app.Application

class App : Application() {
    override fun onLowMemory() {
        super.onLowMemory()
    }
}