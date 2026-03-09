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
            //pulls the checked ID from radOrder.
            val orderbtn = findViewById<RadioButton>(radOrder.checkedRadioButtonId)
            val order = orderbtn?.text
            //checking if our user entered their name.
            if (editName.text.toString() == "") {
                Log.d("NameError","Name Not Entered")
                error = true
                nameError.visibility = View.VISIBLE
            }
            //checking if our user clicked a radio button
            if (order == null) {
                Log.d("RadioError","Order Not Entered")
                error = true
                radioError.visibility = View.VISIBLE
            }
            if (!error) {
                val name = editName.text.toString()
                val intent = Intent(this@MainActivity, OrderActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("order", order)
                //Checking for if we Use Oat milk. done here since it's a bool and more compact than the others.
                if (checkOat.isChecked) {intent.putExtra("oat", "Yes")}
                else {intent.putExtra("oat","No")}

                startActivity(intent)
            }
        }
        // ^ send in the vals we set up so we can feed them to OrderActivity with intent.putextra(?)
    }
}