package com.example.prova.Activity.Produto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.prova.Controller.DataBaseHandler
import com.example.prova.Controller.produtoUtil
import com.example.prova.Model.Produto
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var db = DataBaseHandler(this)

        var quantidade = findViewById<TextView>(R.id.txt_quantidade)
        var preco = findViewById<TextView>(R.id.txt_preco)
        var produto = findViewById<TextView>(R.id.txt_produto)

        quantidade.text = produtoUtil.quantidade
        preco.text = produtoUtil.preco
        produto.text = produtoUtil.nome

        btn_editar.setOnClickListener {

            var produto1 = Produto(txt_produto.text.toString(), txt_quantidade.text.toString(), txt_preco.text.toString())
            db.updateData(produto1)
            finish()
            startActivity(Intent(this, MenuActivity::class.java))
        }

        btn_excluir.setOnClickListener {
            db.deleteData(produtoUtil.id!!)
            startActivity(Intent(this, MenuActivity::class.java))
        }

        btn_voltar.setOnClickListener {
            finish()
            startActivity(Intent(this, MenuActivity::class.java))
        }

    }
}
