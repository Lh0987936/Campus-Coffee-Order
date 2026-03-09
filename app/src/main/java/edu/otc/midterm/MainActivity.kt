package edu.otc.midterm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editName = findViewById<EditText>(R.id.nameEdit)
        val radOrder = findViewById<RadioGroup>(R.id.drinkChoiceRGroup)
        val checkOat = findViewById<CheckBox>(R.id.oatCheck)
        val btnSubmit = findViewById<Button>(R.id.submitOrder)
        val nameError = findViewById<TextView>(R.id.nameError)
        val radioError = findViewById<TextView>(R.id.radioError)

        btnSubmit.setOnClickListener  { v->
            var error = false
            val orderbtn = findViewById<RadioButton>(radOrder.checkedRadioButtonId)
            val order = orderbtn?.text
            if (editName.text.toString() == "") {
                Log.d("Click","Name Not Entered")
                error = true
                nameError.visibility = View.VISIBLE
            }
            if (order == null) {
                Log.d("Click","Order Not Entered")
                error = true
                radioError.visibility = View.VISIBLE
            }
            if (!error) {
                val name = editName.text.toString()
                val intent = Intent(this@MainActivity, OrderActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("order", order)
                if(checkOat.isChecked) {intent.putExtra("oat", "Yes")}
                else {intent.putExtra("oat","No")}

                startActivity(intent)
        }
//            Log.d("Click",editName.text.toString())
        }
        // ^ send in the vals we set up so we can feed them to OrderActivity with intent.putextra(?)
    }
}