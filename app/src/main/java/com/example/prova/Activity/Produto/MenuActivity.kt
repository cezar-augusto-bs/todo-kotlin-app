package com.example.prova.Activity.Produto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btn_inserir.setOnClickListener {
            startActivity(Intent(this, InserirActivity::class.java))
        }
        btn_listar.setOnClickListener {
            startActivity(Intent(this, ListarActivity::class.java))
        }
        btn_pesquisar.setOnClickListener {
            startActivity(Intent(this, PesquisarActivity::class.java))
        }
    }
}
