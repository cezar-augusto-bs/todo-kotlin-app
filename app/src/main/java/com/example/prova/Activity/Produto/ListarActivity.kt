package com.example.prova.Activity.Produto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.example.prova.Controller.DataBaseHandler
import com.example.prova.Model.Produto
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_listar.*

class ListarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        var i = 0

        var db = DataBaseHandler(this)

        var lista = db.readData()

        if (i >= lista.size) {

        } else {
            txt_produto.text = lista.get(i).nome
            txt_preco.text = lista.get(i).preco
            txt_quantidade.text = lista.get(i).quantidade
        }

        btn_proximo.setOnClickListener {
            i++
            if (i >= lista.size) {
            } else {
                txt_produto.text = lista.get(i).nome
                txt_preco.text = lista.get(i).preco
                txt_quantidade.text = lista.get(i).quantidade
            }
        }
        btn_anterior.setOnClickListener {


            if (i >= lista.size) {
                i = lista.size - 1
                i--
                txt_produto.text = lista.get(i).nome
                txt_preco.text = lista.get(i).preco
                txt_quantidade.text = lista.get(i).quantidade
            } else {
                if (i <= 0) {

                } else {
                    i--
                    txt_produto.text = lista.get(i).nome
                    txt_preco.text = lista.get(i).preco
                    txt_quantidade.text = lista.get(i).quantidade
                }
            }
        }


        /* i= i-1
        if(i <= lista.size) {

        } else {
            txt_produto.text = lista.get(i).nome
            txt_preco.text = lista.get(i).preco
            txt_quantidade.text = lista.get(i).quantidade
        }
    }
    btn_voltar.setOnClickListener {
        finish()
        startActivity(Intent(this, MenuActivity::class.java))

    }

        */
    }

}
