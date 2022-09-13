package com.example.spinnerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvDay = findViewById<TextView>(R.id.tvDay)
        val spdays = findViewById<Spinner>(R.id.spDays)

        // if we need to set the array by code so must to use these cods below
        val listOfDays = listOf<String>("one", "tow", "three", "four","fife","six")
        val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listOfDays)
        spdays.adapter = adapter
        // until above code

        spdays.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               Toast.makeText(this@MainActivity,
               "You Selected ${parent?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).show()
                   tvDay.text = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}