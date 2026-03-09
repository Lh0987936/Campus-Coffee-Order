package edu.otc.midterm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nameEnter = findViewById<TextView>(R.id.nameText)
        val orderEnter = findViewById<TextView>(R.id.orderText)
        val oatEnter = findViewById<TextView>(R.id.oatText)
        val backButton = findViewById<Button>(R.id.backButton)

        nameEnter.text = intent.getStringExtra("name")
        orderEnter.text = intent.getStringExtra("order")
        oatEnter.text = intent.getStringExtra("oat")
        Log.d("OnCreate", "ITS ALIVEEEEE")

        backButton.setOnClickListener { v->
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("OnStart", "Starting..." )
    }
    override fun onResume() {
        super.onResume()
        Log.d("OnResume", "And we pick up where we last left off-")
    }
    override fun onPause() {
        super.onPause()
        Log.d("OnPause", "We have paused")
    }
    override fun onStop() {
        super.onStop()
        Log.d("OnStop", "STOP, WAITAMINUTE")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("OnRestart", "We've restarted!")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy", "DESTROYED")
    }
}