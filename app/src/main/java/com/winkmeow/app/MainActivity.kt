package com.winkmeow.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.PI

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    private var input: CharSequence? = null
    var nums = mutableListOf<CharSequence?>()
    var ans: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }
    var num: Double = 0.0

    fun onPress(view: View){
        input = ((view as Button).text)
        if (input == "pi"){
            tvInput?.append("\u03c0")
            Toast.makeText(this, "\u03c0", Toast.LENGTH_SHORT).show()
        }
        else if (input?.any { it.isDigit() } == true && input != "X\u207B\u00B9")  {
            tvInput?.append((input).toString())
        }
        if (input == "E"){
            tvInput?.append("E")
            //Toast.makeText(this, "\u03c0", Toast.LENGTH_SHORT).show()
        }
        else if (input == "%"){
            nums.add(tvInput?.text)
            Toast.makeText(this, nums[0], Toast.LENGTH_SHORT).show()
            tvInput?.append(input)
            println(nums[0])

        }
        else if (input == "="){
            var temp: String = tvInput?.text.toString().substring(1)
            println(nums)
            nums.add(temp)

            ans = ((nums[0].toString().toInt()) % (nums[1].toString().toInt()))
            Toast.makeText(this, ans.toString(), Toast.LENGTH_SHORT).show()
        }
        else if (input == "CLR") {
            tvInput?.text = ""
            Toast.makeText(this, "cleared", Toast.LENGTH_SHORT).show()
        }
        else if (input == "X\u207B\u00B9"){
            Toast.makeText(this, (1/(tvInput?.text).toString().toDouble()).toString(), Toast.LENGTH_SHORT).show()
            tvInput?.text = (1.0/((tvInput?.text).toString().toDouble())).toString()
            
        }
        //Toast.makeText(this, input.toString(), Toast.LENGTH_SHORT).show()

    }
}
