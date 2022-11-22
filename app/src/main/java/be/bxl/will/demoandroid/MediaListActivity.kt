package be.bxl.will.demoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.bxl.will.demoandroid.adapters.MediaAdapter
import be.bxl.will.demoandroid.models.Media

class MediaListActivity : AppCompatActivity() {

    companion object {
        val TAG = MediaListActivity::class.java.simpleName
    }

    private lateinit var rvMedia : RecyclerView

    private lateinit var adapter : MediaAdapter

    private val mediaList : MutableList<Media> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_list)

        mediaList.add(Media("Movie", "Harry Potter", "C'est un sorcier", 123456, 1))
        mediaList.add(Media("Book", "La distinction", "C'est un sociologue", 123456, 2))
        mediaList.add(Media("Music", "Nirvana", "C'est de la musique", 123456, 3))

        adapter = MediaAdapter(mediaList) {
            Log.d(TAG, it.toString())
        }
        rvMedia = findViewById(R.id.rv_media_media_list)
        rvMedia.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvMedia.adapter = adapter
    }
}