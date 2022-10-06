package diplomado.unicafam.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity() {
    var operation: Int = 0
    var numero1: Double = 0.0
    lateinit var ed_number1: TextView
    lateinit var ed_number2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_number1 = findViewById(R.id.ed_number1)
        ed_number2 = findViewById(R.id.ed_number2)
        val btn_cut: Button = findViewById(R.id.btn_cut)
        val btn_equal: Button = findViewById(R.id.btn_equal)

        btn_equal.setOnClickListener {
            var numero2: Double = ed_number2.text.toString().toDouble()
            var response: Double = 0.0

            when(operation){
                1 -> response = numero1 + numero2
                2 -> response = numero1 - numero2
                3 -> response = numero1 * numero2
                4 -> response = numero1 / numero2
            }

            ed_number2.setText(response.toString())
            ed_number1.setText("")
        }
        btn_cut.setOnClickListener {
            ed_number1.setText("")
            ed_number2.setText("")
            numero1 = 0.0
            operation = 0
        }
    }

    fun presionarNumb(view : View){
        //val ed_number2: TextView = findViewById(R.id.ed_number2)
        var num2: String = ed_number2.text.toString()

        when(view.id){
            R.id.numb_zero -> ed_number2.setText(num2 + "0")
            R.id.numb_1 -> ed_number2.setText(num2 + "1")
            R.id.numb_2 -> ed_number2.setText(num2 + "2")
            R.id.numb_3 -> ed_number2.setText(num2 + "3")
            R.id.numb_4  -> ed_number2.setText(num2 + "4")
            R.id.numb_5 -> ed_number2.setText(num2 + "5")
            R.id.numb_6 -> ed_number2.setText(num2 + "6")
            R.id.numb_7 -> ed_number2.setText(num2 + "7")
            R.id.numb_8 -> ed_number2.setText(num2 + "8")
            R.id.numb_9 -> ed_number2.setText(num2 + "9")
            R.id.btn_point -> ed_number2.setText(num2 + ".")
        }
    }

    fun clicOperacion(view: View){
        numero1 = ed_number2.text.toString().toDouble()
        var num2_text: String = ed_number2.text.toString()
        ed_number2.setText("")
        when(view.id) {
            R.id.btn_sumar -> {
                ed_number1.setText(num2_text + "+")
                operation = 1
            }
            R.id.btn_subtract -> {
                ed_number1.setText(num2_text + "-")
                operation = 2
            }
            R.id.btn_multiply -> {
                ed_number1.setText(num2_text + "X")
                operation = 3
            }
            R.id.btn_divide -> {
                ed_number1.setText(num2_text + "/")
                operation = 4
            }
        }
    }
}