package com.example.prova.Activity.Usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova.Activity.Produto.MenuActivity
import com.example.prova.Controller.DataBaseHandler
import com.example.prova.Model.Usuarios
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val db = DataBaseHandler (this)

        btn_anterior.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btn_cadastrar.setOnClickListener {
            val usuario = Usuarios(txt_nome.text.toString(), txt_email.text.toString(), txt_senha.text.toString())
            db.inserirUsuario(usuario)
            finish()
            startActivity(Intent(this, MenuActivity::class.java))

        }

    }
}
