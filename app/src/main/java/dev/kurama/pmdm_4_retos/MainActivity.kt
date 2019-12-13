package dev.kurama.pmdm_4_retos

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse


const val REQUEST_RETO_1 = 1
const val REQUEST_RETO_2 = 2
const val REQUEST_RETO_3 = 3
const val REQUEST_RETO_4 = 4

const val CODIGO_RESPUESTA = "RESPUESTA"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnReto1.setOnClickListener { abrirReto(it) }
        btnReto2.setOnClickListener { abrirReto(it) }
        btnReto3.setOnClickListener { abrirReto(it) }
        btnReto4.setOnClickListener { abrirReto(it) }

        btnGithub.setOnClickListener { browse("https://github.com/fsancheztemprano/PMDM_4_Retos") }
    }

    private fun abrirReto(it: View?) {
        val intent: Intent?
        val request: Int
        Log.d("${it?.id} / ", "${R.id.btnReto2}")

        when (it?.id) {
            R.id.btnReto1 -> {
                intent = Intent(this, Reto1Activity::class.java)
                request = REQUEST_RETO_1
            }
            R.id.btnReto2 -> {
                intent = Intent(this, Reto2Activity::class.java)
                request = REQUEST_RETO_2
            }
            R.id.btnReto3 -> {
                intent = Intent(this, Reto3Activity::class.java)
                request = REQUEST_RETO_3
            }
            R.id.btnReto4 -> {
                intent = Intent(this, Reto4Activity::class.java)
                request = REQUEST_RETO_4
            }
            else -> return
        }
        startActivityForResult(intent, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.let {
            if (resultCode == Activity.RESULT_OK) {
                val resp = data.getBooleanExtra(CODIGO_RESPUESTA, false)
                val view: View? = when (requestCode) {
                    REQUEST_RETO_1 -> findViewById(R.id.btnReto1)
                    REQUEST_RETO_2 -> findViewById(R.id.btnReto2)
                    REQUEST_RETO_3 -> findViewById(R.id.btnReto3)
                    REQUEST_RETO_4 -> findViewById(R.id.btnReto4)
                    else -> null
                }
                view?.let { (view as Button).setBackgroundColor(if (resp) Color.GREEN else Color.RED) }
            } else {
                Toast.makeText(this, "Errrrrror en la respuesta!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
