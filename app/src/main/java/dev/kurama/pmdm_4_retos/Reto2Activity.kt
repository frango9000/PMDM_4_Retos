package dev.kurama.pmdm_4_retos

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reto2.*

class Reto2Activity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    var fotoSet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto2)
        btnAbrirCam.setOnClickListener { abrirCamAction(it) }
        Log.d("YYYYYYYYYYYYYYY", "")
        btn2volver.setOnClickListener { volver(it) }
        Log.d("ZZZZZZZZZZZZZZZ", "")
    }

    private fun volver(it: View?) {
        intent.putExtra(CODIGO_RESPUESTA, fotoSet)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun abrirCamAction(it: View?) {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imgFoto?.apply {
                setImageBitmap(imageBitmap)
                fotoSet = true
            }
        } else {
            Toast.makeText(this, "Errrrrror en la respuesta!", Toast.LENGTH_SHORT).show()
        }
    }
}
