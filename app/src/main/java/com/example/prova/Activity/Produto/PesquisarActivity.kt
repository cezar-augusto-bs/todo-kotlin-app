package com.example.prova.Activity.Produto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prova.Controller.DataBaseHandler
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_pesquisar.*

class PesquisarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar)


        var db = DataBaseHandler(this)
        btn_pesquisar.setOnClickListener {

            if(db.pesquisarProduto(txt_pesquisa.text.toString())) {
                finish()
                startActivity(Intent(this, ResultadoActivity::class.java))
            } else {
                Toast.makeText(this, "Produto não registrado", Toast.LENGTH_SHORT).show()
            }



        }
        btn_voltar.setOnClickListener {
            finish()
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}
