package com.example.listadesejo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etDescricao: EditText = findViewById(R.id.etDescricao)
        val valor: EditText = findViewById(R.id.etValor)

        val btnCadastrar: Button = findViewById(R.id.btnCadastrar)
        val btnCancelar: Button = findViewById(R.id.btnCancelar)

        btnCadastrar.setOnClickListener {
            val intent = Intent()

            val descricao = etDescricao.text.toString()
            val valor = valor.text.toString()

            val obj = Desejo(descricao, valor)

            if (descricao.length > 0 && valor.length > 0) {
                intent.putExtra("objVolta", obj)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "Preencha os campos!", Toast.LENGTH_LONG).show()
            }
        }

        btnCancelar.setOnClickListener {
            finish()
        }

    }
}