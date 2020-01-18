package com.example.prova.Model

class Produto {

    var id: String ?= null
    var nome: String ?= null
    var quantidade: String ?= null
    var preco: String ?= null

    constructor(nome: String, quantidade: String, preco: String) {
        this.nome = nome
        this.quantidade = quantidade
        this.preco = preco
    }

    constructor()


}