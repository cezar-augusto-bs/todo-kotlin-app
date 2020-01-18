package com.example.prova.Activity.Usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btn_cadastro.setOnClickListener {
            finish()
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }
}
