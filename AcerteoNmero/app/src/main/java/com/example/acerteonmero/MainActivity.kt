package com.example.acerteonmero

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    private lateinit var btnMainNovo : Button
    private lateinit var btnMainChute : Button
    private lateinit var etMainChute : EditText
    private lateinit var tvMainDica1 : TextView
    private lateinit var tvMainDica2 : TextView
    private lateinit var tvMainDica3 : TextView
    private lateinit var ivMainIcon : ImageView
    private lateinit var llMainChute : LinearLayout
    private lateinit var alertDialog : AlertDialog

    private var numero : Int = 0
    private var tentativa : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainNovo = findViewById(R.id.btnMainNovo)
        ivMainIcon = findViewById(R.id.ivMainIcon)

        tvMainDica1 = findViewById(R.id.tvMainDica1)
        tvMainDica2 = findViewById(R.id.tvMainDica2)
        tvMainDica3 = findViewById(R.id.tvMainDica3)

        etMainChute = findViewById(R.id.etMainChute)
        btnMainChute = findViewById(R.id.btnMainChute)
        llMainChute = findViewById(R.id.llMainChute)
        resetar()
        comecar()

        btnMainNovo.setOnClickListener(OnClickBotaoGerarNovo())
        btnMainChute.setOnClickListener(OnClickBotaoChutar())

        alertDialog = AlertDialog.Builder(this@MainActivity).create()
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
            DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() })
    }

    private fun ganhou() {
        alertDialog.setTitle("Ganhou")
        alertDialog.setMessage("Você acertou o número na sua ${tentativa} tentativa")
        ivMainIcon.setImageResource(R.drawable.baseline_done_outline)
        resetar()
        alertDialog.show()
    }

    private fun perdeu() {
        alertDialog.setTitle("Perdeu")
        alertDialog.setMessage("Você excedeu o número de tentativas e não acertou mesmo com as dicas")
        ivMainIcon.setImageResource(R.drawable.baseline_highlight_off)
        resetar()
        alertDialog.show()
    }

    private fun comecar() {
        numero = (0..101).random()
        tentativa = 0
        ivMainIcon.setImageResource(R.drawable.baseline_help_outline)
        llMainChute.visibility = View.VISIBLE
        Log.i("APP_ACERTE", numero.toString())
        btnMainNovo.visibility = View.INVISIBLE
    }

    private fun resetar() {
        llMainChute.visibility = View.INVISIBLE
        etMainChute.setText("")
        btnMainNovo.visibility = View.VISIBLE
        tvMainDica1.text = "Dica 1:"
        tvMainDica2.text = "Dica 2:"
        tvMainDica3.text = "Dica 3:"
    }

    private fun darPrimeiraDica() {
        var dica1 = ""
        for (i in (1..10)) {
            dica1 += if (numero % i == 0) "${i} " else ""
        }
        tvMainDica1.text = "Dica 1: Número é divisivel por ( ${dica1})"
    }

    private fun darSegundaDica() {
        val dica2 = if (numero % 2 == 0) "par" else "impar"
        tvMainDica2.text = "Dica 2: Número é ${dica2}"
    }

    private fun darTerceiraDica() {
        var totalDivisores : Int = 0
        for ( i in 1..sqrt(numero.toDouble()).toInt()+1) {
            if (numero % i == 0) {
                totalDivisores += if (numero / i == i) 1 else 2
            }
        }
        tvMainDica3.text = "Dica 3: total número de divisores é ${totalDivisores}"
    }

    inner class OnClickBotaoGerarNovo: View.OnClickListener {
        override fun onClick(v: View?) {
            comecar()
        }
    }

    inner class OnClickBotaoChutar: View.OnClickListener {
        override fun onClick(v: View?) {
            val chute : Int = etMainChute.text.toString().toInt()
            if (chute == numero) {
                ganhou()
                return
            }
            tentativa += 1
            if (tentativa > 3) {
                perdeu()
                return
            }
            when(tentativa) {
                1 -> darPrimeiraDica()
                2 -> darSegundaDica()
                3 -> darTerceiraDica()
            }
        }
    }
}
