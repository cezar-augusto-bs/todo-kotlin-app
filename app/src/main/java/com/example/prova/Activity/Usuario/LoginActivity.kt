package com.example.prova.Activity.Usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prova.Activity.Produto.MenuActivity
import com.example.prova.Controller.DataBaseHandler
import com.example.prova.Controller.usuarioUtil
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var db = DataBaseHandler(this)

        btn_anterior.setOnClickListener {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_logar.setOnClickListener {

           if(db.logarUsuario(txt_email.text.toString(), txt_senha.text.toString())) {

               finish()
               startActivity(Intent(this, MenuActivity::class.java))

           } else {
               Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_LONG).show()
           }

        }

    }
}
