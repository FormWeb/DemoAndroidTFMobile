package be.bxl.will.demoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import be.bxl.will.demoandroid.models.Media

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
        val MEDIA_CODE = "media"
        val RESULT_CODE = "message"
    }

    private lateinit var btnGoToLinear : Button
    private lateinit var btnGoToAreYouSerious : Button
    private lateinit var btnGoToMediaList : Button

    private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = getString(R.string.title_main_activity)
        Log.d(TAG, title)

        btnGoToLinear = findViewById(R.id.btn_go_to_linear_main)
        btnGoToAreYouSerious = findViewById(R.id.btn_dont_click_main)
        btnGoToMediaList = findViewById(R.id.btn_go_to_media_list)

        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data : Intent? = it.data
                val message = data?.getStringExtra(RESULT_CODE)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }

        btnGoToLinear.setOnClickListener {
            val intent = Intent(this, LinearActivity::class.java)
            val newMedia = Media(
                "Movie", "Harry Potter", "C'est un sorcier",
                123456, 1
            )
            intent.putExtra(MEDIA_CODE, newMedia)
            startActivity(intent)
            // Pour finish l'activité
            // finish()
        }

        btnGoToAreYouSerious.setOnClickListener {
            val intent = Intent(this, AreYouSeriousActivity::class.java)
            activityResultLauncher.launch(intent)
        }

        btnGoToMediaList.setOnClickListener {
            val intent = Intent(this, MediaListActivity::class.java)
            startActivity(intent)
        }

        manageSharedPreference()
    }

    private fun manageSharedPreference() {
        val sharedPref = getSharedPreferences("my_shared_pref", MODE_PRIVATE)
        // Equivalent sans with
//        val editor = sharedPref.edit()
//        editor.putString("myKey", "myValue")
//        editor.apply()

        with (sharedPref.edit()) {
            putString("myKey", "myValue")
            apply()
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