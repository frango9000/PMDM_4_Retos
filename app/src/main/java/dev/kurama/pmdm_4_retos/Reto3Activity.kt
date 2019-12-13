package dev.kurama.pmdm_4_retos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reto3.*
import java.util.*

class Reto3Activity : AppCompatActivity() {
    val list = listOf(
        Cientifico("Marie Curie", 1867),
        Cientifico("Albert Einstein", 1879),
        Cientifico("Wernher von Braun", 1912),
        Cientifico("Galileo Galilei", 1564),
        Cientifico("Stephen Hawking", 1942)
    )
    val n = Random().nextInt(list.size - 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto3)
        textViewNombre.text = list[n].nombre
        btnGoTrivia.setOnClickListener { responder(it) }
    }


    //verificar respuesta y retornar resultado true/false
    private fun responder(it: View?) {
        val intent = Intent()
        var resp = false
        try {
            var anho = Integer.parseInt(textRespuesta.text.toString())
            resp = anho == list[n].anho
        } catch (e: Exception) {
        } finally {

            intent.putExtra(CODIGO_RESPUESTA, resp)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


}

//clase de datos a solicitar
data class Cientifico(
    val nombre: String,
    val anho: Int
)