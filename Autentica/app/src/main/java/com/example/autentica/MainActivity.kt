package com.example.autentica

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var etUsuario : EditText
    private lateinit var etSenha : EditText
    private lateinit var btCancelar : Button
    private lateinit var btOkay : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCancelar = findViewById(R.id.btCancelar)
        btOkay = findViewById(R.id.btOkay)

        etUsuario = findViewById(R.id.etUsuario)
        etSenha = findViewById(R.id.etSenha)


        btCancelar.setOnClickListener {
            Log.i("", "i - Cancelou")
            Log.e("APP_AUTENTICA", "e - Cancelou")
            Log.w("APP_AUTENTICA", "w - Cancelou")
            Toast.makeText(this, "Você cancelou", Toast.LENGTH_LONG).show()
            etSenha.text.clear()
            etUsuario.text.clear()
        }

        btOkay.setOnClickListener(OnClickButao())
    }

    inner class OnClickButao : View.OnClickListener {
        override fun onClick(v: View?) {
            val usuario = this@MainActivity.etUsuario.text.toString()
            val senha = this@MainActivity.etSenha.text.toString()

            Log.i("APP_AUTENTICA", "$usuario - $senha")

            if (usuario == "admin" && senha == "1234") {
                Toast.makeText(this@MainActivity, "Sucesso!", Toast.LENGTH_SHORT).show()
                val myIntent = Intent(this@MainActivity, FirstPage::class.java)
                startActivity(myIntent)
                Log.i("APP_AUTENTICA", "Deu certo!")
            } else {
                Toast.makeText(this@MainActivity, "Erro!", Toast.LENGTH_SHORT).show()
                Log.i("APP_AUTENTICA", "Deu errado!")
            }
        }
    }

}
