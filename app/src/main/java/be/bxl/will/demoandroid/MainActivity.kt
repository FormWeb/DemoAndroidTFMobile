package be.bxl.will.demoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import be.bxl.will.demoandroid.models.Media

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
        val MEDIA_CODE = "media"
    }

    private lateinit var btnGoToLinear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = getString(R.string.title_main_activity)
        Log.d(TAG, title)

        btnGoToLinear = findViewById(R.id.btn_go_to_linear_main)

        btnGoToLinear.setOnClickListener {
            val intent = Intent(this, LinearActivity::class.java)
            val newMedia = Media("Movie", "Harry Potter", "C'est un sorcier",
                123456, 1)
            intent.putExtra(MEDIA_CODE, newMedia)
            startActivity(intent)
            // Pour finish l'activité
            // finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
}