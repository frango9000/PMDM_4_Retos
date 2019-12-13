package dev.kurama.pmdm_4_retos

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reto1.*
import java.util.*

class Reto1Activity : AppCompatActivity() {
    val num1: Int = Random().nextInt(99) + 1
    val num2: Int = Random().nextInt(99) + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto1)
        textNum1.text = num1.toString()
        textNum2.text = num2.toString()

        btnResp1.setOnClickListener { procesarRespuesta(it) }
    }

    private fun procesarRespuesta(it: View?) {
        try {
            val resp = Integer.parseInt(txt1Respuesta.editableText.toString())
//            val intent =Intent()
//            Log.d((num1+num2).toString(), resp.toString())
            intent.putExtra(CODIGO_RESPUESTA, (num1 + num2) == resp)
            setResult(Activity.RESULT_OK, intent)
            finish()
        } catch (e: Exception) {
            Toast.makeText(this, "Respuesta Invalida", Toast.LENGTH_SHORT).show()
        }
    }
}
