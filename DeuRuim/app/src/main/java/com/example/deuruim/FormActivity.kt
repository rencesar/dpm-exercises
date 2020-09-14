package com.example.deuruim

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import androidx.core.view.drawToBitmap

class FormActivity : AppCompatActivity() {
    private lateinit var btCancelar : Button
    private lateinit var btSalvar : Button
    private lateinit var btImage : Button
    private lateinit var etDescricao : EditText
    private lateinit var sbProgress : SeekBar
    private lateinit var ivImage : ImageView

    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        etDescricao = findViewById(R.id.etFormDescricao)
        sbProgress = findViewById(R.id.sbFormProgress)
        ivImage = findViewById(R.id.ivFormImage)

        btCancelar = findViewById(R.id.btFormCancelar)
        btSalvar = findViewById(R.id.btFormSalvar)
        btImage = findViewById(R.id.btFormImage)

        this.btCancelar.setOnClickListener {
            finish()
        }
        this.btSalvar.setOnClickListener {
            salvar()
        }
        this.btImage.setOnClickListener {
            tirarFoto()
        }
    }

    fun salvar() {
        val descricao = this.etDescricao.text.toString()
        val nota = this.sbProgress.progress
        val foto : Bitmap = this.ivImage.drawToBitmap()

        val evento = Evento(descricao, nota, foto)

        val intent = Intent()
        intent.putExtra("EVENTO", evento)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }

    private fun tirarFoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ivImage.setImageBitmap(imageBitmap)
        }
    }
}
