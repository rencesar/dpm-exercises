package com.example.popup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.sql.Time

class MainActivity : AppCompatActivity() {
    private lateinit var btMensagem : Button
    private lateinit var btInput : Button
    private lateinit var btData : Button
    private lateinit var btHora : Button
    private lateinit var btFaixaValores : Button
    private lateinit var btEscolha : Button
    private lateinit var btUnico : Button
    private lateinit var btVarios : Button
    private lateinit var view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMensagem = this.findViewById(R.id.btMensagem)
        btInput = this.findViewById(R.id.btInput)
        btData = this.findViewById(R.id.btData)
        btHora = this.findViewById(R.id.btHora)
        btFaixaValores = this.findViewById(R.id.btFaixaValores)
        btEscolha = this.findViewById(R.id.btEscolha)
        btUnico = this.findViewById(R.id.btUnico)
        btVarios = this.findViewById(R.id.btVarios)


        btMensagem.setOnClickListener { mensagem() }
        btInput.setOnClickListener { input() }
        btData.setOnClickListener { data() }
        btHora.setOnClickListener { hora() }
        btFaixaValores.setOnClickListener { faixaValores() }
        btEscolha.setOnClickListener { escolha() }
        btUnico.setOnClickListener { unico() }
        btVarios.setOnClickListener { varios() }

    }

    fun mensagem() {
        val janela = AlertDialog.Builder(this)
        janela.setTitle("Input")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Que bom!")

        janela.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.setNeutralButton("Generico") { dialog, which ->
            Toast.makeText(this, "Generico", Toast.LENGTH_SHORT).show()

        }
        janela.create().show()
    }

    fun input() {
        val janela = AlertDialog.Builder(this)
        this.view = EditText(this)
        janela.setTitle("Menagem")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase")
        janela.setView(this.view)

        janela.setPositiveButton("OK") { dialog, which ->
            val mensagem = (this.view as EditText).text.toString()
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()

    }

    fun data() {
        val janela = AlertDialog.Builder(this)
        this.view = DatePicker(this)
        janela.setTitle("Data")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite a data")
        janela.setView(this.view)

        janela.setPositiveButton("OK") { dialog, which ->
            val dp = this.view as DatePicker
            val mensagem = "${dp.dayOfMonth}/${dp.month + 1}/${dp.year}"
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()

    }

    fun hora() {
        val janela = AlertDialog.Builder(this)
        this.view = TimePicker(this)
        (this.view as TimePicker).setIs24HourView(true)
        janela.setTitle("Hora")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma hora")
        janela.setView(this.view)

        janela.setPositiveButton("OK") { dialog, which ->
            val tp = this.view as TimePicker
            var mensagem = ""
            if (Build.VERSION.SDK_INT < 23) {
                mensagem = "${tp.currentHour}:${tp.currentMinute.toString().padEnd(2, '0')}"
            } else {
                mensagem = "${tp.hour}:${tp.minute.toString().padEnd(2, '0')}"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()

    }

    fun faixaValores() {
        val janela = AlertDialog.Builder(this)
        this.view = SeekBar(this)
        (this.view as SeekBar).max = 100
        janela.setTitle("Seekbar")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha um valor")
        janela.setView(this.view)

        janela.setPositiveButton("OK") { dialog, which ->
            val sb = this.view as SeekBar

            Toast.makeText(this, sb.progress.toString(), Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()

    }

    fun escolha() {
        val janela = AlertDialog.Builder(this)
        this.view = Switch(this)

        janela.setTitle("Seekbar")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha um valor")
        janela.setView(this.view)

        janela.setPositiveButton("OK") { dialog, which ->
            val sw = this.view as Switch
            val msg = if (sw.isChecked) "Não" else "Sim"

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun unico() {
        val janela = AlertDialog.Builder(this)
        this.view = RadioGroup(this)
        val radioSim = RadioButton(this)
        val radioNao = RadioButton(this)
        radioSim.text = "Sim"
        radioNao.text = "Não"
        (this.view as RadioGroup).addView(radioSim)
        (this.view as RadioGroup).addView(radioNao)

        janela.setTitle("Seekbar")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha um valor")
        janela.setView(this.view)

        janela.setPositiveButton("OK") { dialog, which ->
            val rg = this.view as RadioGroup
            val msg = if (rg.) "Sim" else "Não"

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun varios() {

    }
}
