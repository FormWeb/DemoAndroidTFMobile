package be.bxl.will.demoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import be.bxl.will.demoandroid.databinding.ActivityAreYouSeriousBinding

class AreYouSeriousActivity : AppCompatActivity() {

    companion object {
        val TAG = AreYouSeriousActivity::class.java.simpleName
    }

    private lateinit var binding : ActivityAreYouSeriousBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAreYouSeriousBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnYesAys.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MainActivity.RESULT_CODE, "Yes")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.btnNoAys.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MainActivity.RESULT_CODE, "No")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        manageSharedPreference()
    }

    private fun manageSharedPreference() {
        val sharedPref = getSharedPreferences("my_shared_pref", MODE_PRIVATE)
        val message = sharedPref.getString("myKey", null)
        if (message != null) {
            Log.d(TAG, message)
        }
    }
}