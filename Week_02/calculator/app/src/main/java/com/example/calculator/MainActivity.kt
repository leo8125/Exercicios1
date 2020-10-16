package com.example.calculator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

const val RESULT_MESSAGE = ""

class MainActivity : AppCompatActivity() {
    lateinit var tv1 :EditText
    lateinit var tv2 :EditText
    lateinit var bt1 :Button
    lateinit var bt2 :Button
    lateinit var bt3 :Button
    lateinit var bt4 :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1=findViewById(R.id.tvValue1)
        bt1=findViewById(R.id.btAddition)
        tv2=findViewById(R.id.tvValue2)
        bt2=findViewById(R.id.btSubtraction)
        bt3=findViewById(R.id.btMultiplication)
        bt4=findViewById(R.id.btDivision)

            val value = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var tvValue01Input = tv1.getText().toString().trim()
                    var tvValue02Input = tv2.getText().toString().trim()

                    bt1.setEnabled(!tvValue01Input.isEmpty() && !tvValue02Input.isEmpty())
                    bt2.setEnabled(!tvValue01Input.isEmpty() && !tvValue02Input.isEmpty())
                    bt3.setEnabled(!tvValue01Input.isEmpty() && !tvValue02Input.isEmpty())
                    bt4.setEnabled(!tvValue01Input.isEmpty() && !tvValue02Input.isEmpty())
                }
            }


        tv1.addTextChangedListener(value)
        tv2.addTextChangedListener(value)

        btAddition.setOnClickListener {
            var value1 = tvValue1.text.toString()
            var value2 = tvValue2.text.toString()
            val value3 = value1.toInt()
            val value4 = value2.toInt()
            var res = value3 + value4
            val intent = Intent(this, result::class.java).apply {
                putExtra(RESULT_MESSAGE, res)
            }
                    startActivity(intent)
                }

        btSubtraction.setOnClickListener {
            var value1 = tvValue1.text.toString()
            var value2 = tvValue2.text.toString()
            val value3 = value1.toInt()
            val value4 = value2.toInt()
            var res = value3 - value4
            val intent =  Intent(this, result::class.java).apply {
                putExtra(RESULT_MESSAGE,res)
            }
            startActivity(intent)
        }
        btMultiplication.setOnClickListener {
            var value1 = tvValue1.text.toString()
            var value2 = tvValue2.text.toString()
            val value3 = value1.toInt()
            val value4 = value2.toInt()
            var res =  value3 * value4
            val intent =  Intent(this, result::class.java).apply {
                putExtra(RESULT_MESSAGE, res)
            }
            startActivity(intent)
        }
        btDivision.setOnClickListener {
            var value1 = tvValue1.text.toString()
            var value2 = tvValue2.text.toString()
            val value3 = value1.toInt()
            val value4 = value2.toInt()
            var res = value3 / value4
            val intent =  Intent(this, result::class.java).apply {
                putExtra(RESULT_MESSAGE,res)
            }
            startActivity(intent)
        }
    }
}