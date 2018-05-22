package com.m68476521.mike.kalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operation = "*"
    var oldNumber = ""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumberEvent(view: View) {
        if (isNewOperation) {
            editTextOperation.setText("")
        }
        isNewOperation = false
        val buttonSelected = view as Button
        var buttonClickValue: String = editTextOperation.text.toString()
        when (buttonSelected.id) {
            button0.id -> {
                buttonClickValue += "0"
            }

            button1.id -> {
                buttonClickValue += "1"
            }

            button2.id -> {
                buttonClickValue += "2"
            }

            button3.id -> {
                buttonClickValue += "3"
            }

            button4.id -> {
                buttonClickValue += "4"
            }

            button5.id -> {
                buttonClickValue += "5"
            }

            button6.id -> {
                buttonClickValue += "6"
            }

            button7.id -> {
                buttonClickValue += "7"
            }

            button8.id -> {
                buttonClickValue += "8"
            }

            button9.id -> {
                buttonClickValue += "9"
            }

            button_plus_minus.id -> {
                buttonClickValue = "-" + buttonClickValue
            }

            buttonDot.id -> {
                buttonClickValue += "."
            }
        }
        editTextOperation.setText(buttonClickValue)
    }

    fun viewOperationEvent(view: View) {
        val buttonSelected = view as Button

        when (buttonSelected.id) {
            buttonMul.id -> {
                operation = "*"
            }
            buttonDiv.id -> {
                operation = "/"
            }

            buttonSub.id -> {
                operation = "-"
            }

            buttonAdition.id -> {
                operation = "+"
            }
        }
        oldNumber = editTextOperation.text.toString()
        isNewOperation = true
    }

    fun buttonEqualEvent(view: View) {
        var newNumber = editTextOperation.text.toString()
        var finalResult: Double? = null
        when (operation) {
            "/" -> {
                finalResult = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*" -> {
                finalResult = oldNumber.toDouble() * newNumber.toDouble()
            }

            "-" -> {
                finalResult = oldNumber.toDouble() - newNumber.toDouble()
            }

            "+" -> {
                finalResult = oldNumber.toDouble() + newNumber.toDouble()
            }
        }

        editTextOperation.setText(finalResult.toString())
    }

    fun buttonPercent(view:View) {
        var number = editTextOperation.text.toString().toDouble() / 100
        editTextOperation.setText(number.toString())
        isNewOperation = true
    }

    fun buttonAC(view:View) {
        editTextOperation.setText("0")
        isNewOperation = true
    }
}
