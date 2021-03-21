package com.example.listadesejo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val FORMULARIO = 1
    private val nomes = arrayListOf<String>()

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var lista: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = findViewById(R.id.listaDesejo)

        this.adapter =  ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.nomes)
        this.lista.setAdapter(adapter)

        val fab: View = findViewById(R.id.btnAdicionar)

        fab.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, Formulario::class.java)
            startActivityForResult(intent, FORMULARIO)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if ( requestCode == FORMULARIO) {
                val desejoObj = data?.getSerializableExtra("objVolta") as? Desejo

                this.adapter.add(desejoObj?.toString())
                Toast.makeText(this, "Item adicionado com sucesso!", Toast.LENGTH_LONG).show()

            }
        }
    }



}