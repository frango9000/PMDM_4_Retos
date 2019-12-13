package dev.kurama.pmdm_4_retos

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reto4.*
import org.jetbrains.anko.email

class Reto4Activity : AppCompatActivity() {

    var emailSent = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)
        btnEnviar.setOnClickListener { enviarCorreo(it) }
        btn4Volver.setOnClickListener { volver(it) }
    }

    private fun volver(it: View?) {
        intent.putExtra(CODIGO_RESPUESTA, emailSent)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun enviarCorreo(it: View?) {
        if (!txtCorreo.text.isBlank() || txtDestino.text.isBlank() || txtTitulo.text.isBlank()) {
            email(txtDestino.text.toString(), txtTitulo.text.toString(), txtCorreo.text.toString())
            emailSent = true
        } else Toast.makeText(this, "Errrrrror en la respuesta!", Toast.LENGTH_SHORT).show()
    }
}
