package com.example.prova.Controller

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import android.widget.Toast
import com.example.prova.Model.Produto
import com.example.prova.Model.Usuarios

val DATABASE_NAME = "Prova"
val NOME_TABELA = "Usuarios"
val COL_ID = "id"
val COL_NOME = "nome"
val COL_EMAIL = "email"
val COL_SENHA = "senha"

var NOME_TABELA2 = "Produtos"
val COL_ID1 = "id"
val COL_NOME1 = "nome"
val COL_QUANT = "quant"
val COL_PRECO = "preco"
var COL_ID_USUARIO = "id_usuario"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME, null, 1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + NOME_TABELA + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NOME + " VARCHAR (50)," +
                COL_EMAIL + " VARCHAR (30)," +
                COL_SENHA + " VARCHAR(15));"

        val createTable1 = "CREATE TABLE " + NOME_TABELA2 + " (" +
                COL_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NOME1 + " VARCHAR (50)," +
                COL_QUANT + " VARCHAR (30)," +
                COL_PRECO + " VARCHAR(15)," +
                COL_ID_USUARIO + " VARCHAR (30));"

        db?.execSQL(createTable)
        db?.execSQL(createTable1)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //Funcoes para o usuario


    fun inserirUsuario(usuario: Usuarios) {
        val db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COL_NOME, usuario.nome)
        cv.put(COL_EMAIL, usuario.email)
        cv.put(COL_SENHA, usuario.senha)
        var result = db.insert(NOME_TABELA, null, cv)
        //insert into nome_tabela(nome, email, senha)

        if (result == -1.toLong())
            Toast.makeText(context, "Erro não realizado", Toast.LENGTH_LONG).show()
    }

    fun logarUsuario(email: String, senha: String): Boolean {
        val db = this.readableDatabase

        val query = "Select * from " + NOME_TABELA + " where " + COL_EMAIL +
                " = '$email' AND " + COL_SENHA + " = '$senha'"
        //select * from nome_tabela where coluna_email = email and coluna_senha = senha

        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            usuarioUtil.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
            usuarioUtil.nome = result.getString(result.getColumnIndex(COL_NOME))
            usuarioUtil.email = result.getString(result.getColumnIndex(COL_EMAIL))
            usuarioUtil.senha = result.getString(result.getColumnIndex(COL_SENHA))
            //usuarioUtil perde os dados quando fecha o app
            return true
        } else {
            return false
        }
    }
    //Funcoes do Produto

    fun inserirProdutos(produto: Produto) {

        var db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COL_NOME1, produto.nome)
        cv.put(COL_PRECO, produto.preco)
        cv.put(COL_QUANT, produto.quantidade)
        cv.put(COL_ID_USUARIO, usuarioUtil.id)

        var result = db.insert(NOME_TABELA2, null, cv)


        if (result == -1.toLong())
            Toast.makeText(context, "Dados não inseridos", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context, "Dados inseridos", Toast.LENGTH_LONG).show()

    }


    fun readData(): MutableList<Produto> {

        var list = mutableListOf<Produto>()

        var db = this.readableDatabase

        var query = "Select * from " + NOME_TABELA2
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var produto = Produto()
                produto.id = result.getString(result.getColumnIndex(COL_ID))
                produto.nome = result.getString(result.getColumnIndex(COL_NOME))
                produto.quantidade = result.getString(result.getColumnIndex(COL_QUANT))
                produto.preco = result.getString(result.getColumnIndex(COL_PRECO))
                list.add(produto)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return list

    }

    fun pesquisarProduto(nome: String): Boolean {

        val db = this.readableDatabase
        var produto = Produto()
        val query = "Select * from " + NOME_TABELA2 + " where " + COL_NOME1 +
                " = '$nome'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            produto.id = result.getString(result.getColumnIndex(COL_ID))
            produto.nome = result.getString(result.getColumnIndex(COL_NOME))
            produto.quantidade = result.getString(result.getColumnIndex(COL_QUANT))
            produto.preco = result.getString(result.getColumnIndex(COL_PRECO))
            produtoUtil = produto
            return true
        } else {
            return false
        }
    }

    fun deleteData(id: String) {
        val db = this.writableDatabase
        db.delete(NOME_TABELA2, COL_ID1 + "=" + id, null)
        db.close()
    }

    fun updateData(produto: Produto) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COL_NOME, produto.nome)
        cv.put(COL_QUANT, produto.quantidade)
        cv.put(COL_PRECO, produto.preco)

        db.update(
            NOME_TABELA2,
            cv,
            COL_ID1 + "='${produtoUtil.id}'",
            null
        )
        db.close()

    }
}


/*
    fun readData(): MutableList<User> {
        var list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.nome = result.getString(result.getColumnIndex(COL_NOME))
                user.cargo = result.getString(result.getColumnIndex(COL_CARGO))
                user.formacao = result.getString(result.getColumnIndex(COL_FORMACAO))
                list.add(user)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun searchData(nome: String): User {
        val db = this.readableDatabase
        var user = User()
        val query = "Select * from " + TABLE_NAME + " where " + COL_NOME +
                " = '$nome'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.nome = result.getString(result.getColumnIndex(COL_NOME))
                user.cargo = result.getString(result.getColumnIndex(COL_CARGO))
                user.formacao = result.getString(result.getColumnIndex(COL_FORMACAO))

            } while (result.moveToNext())
        }
        return user
    }

*/


/*


    }

 */

