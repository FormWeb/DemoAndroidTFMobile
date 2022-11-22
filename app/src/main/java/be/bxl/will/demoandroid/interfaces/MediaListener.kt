package be.bxl.will.demoandroid.interfaces

import be.bxl.will.demoandroid.models.Media

interface MediaListener {
    fun onClick(media : Media)
    fun onDelete(media: Media)
}