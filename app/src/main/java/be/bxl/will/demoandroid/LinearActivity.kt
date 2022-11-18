package be.bxl.will.demoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import be.bxl.will.demoandroid.models.Media

class LinearActivity : AppCompatActivity() {

    companion object {
        val TAG: String = "Linear Activity"
    }

    private lateinit var tvTitle : TextView
    private lateinit var etName : EditText
    private lateinit var btnGetInput : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear)

        initView()
        setupButton()
        tvTitle.text = "Mon nouveau titre !"

        val myMediaFromIntent = intent.getSerializableExtra(MainActivity.MEDIA_CODE) as Media
        Log.d(TAG, myMediaFromIntent.toString())
    }

    private fun initView() {
        tvTitle = findViewById(R.id.tv_title_linear)
        etName = findViewById(R.id.et_name_linear)
        btnGetInput = findViewById(R.id.btn_get_input_linear)
    }

    private fun setupButton() {
        btnGetInput.setOnClickListener {
            Log.d(TAG, "Click")
            val myText = etName.text.toString()
            // Pour changer valeur d'un edit text
            // etName.setText("nigfdngiuf")
            Log.d(TAG, myText)
            Toast.makeText(this, "J'ai faim $myText", Toast.LENGTH_LONG).show()
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
    }
}