package com.example.prova.Activity.Produto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prova.Controller.DataBaseHandler
import com.example.prova.Model.Produto
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_inserir.*

class InserirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserir)

        var db = DataBaseHandler(this)

        btn_inserir.setOnClickListener {

            if (txt_produto.text.toString() != "" && txt_preco.text.toString() != "" && txt_quantidade.text.toString() != "") {
                if (txt_produto.text.toString().length >= 5) {
                    var produto = Produto(
                        txt_produto.text.toString(),
                        txt_quantidade.text.toString(),
                        txt_preco.text.toString()
                    )

                    db.inserirProdutos(produto)

                    finish()
                    startActivity(Intent(this, MenuActivity::class.java))
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }


        }
        btn_voltar.setOnClickListener {
            finish()
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}
