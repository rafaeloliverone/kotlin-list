package com.example.listadesejo

import java.io.Serializable

class Desejo: Serializable {
    var descricao: String;
    var valor: String;

    constructor(descricao: String, valor: String){
        this.descricao = descricao
        this.valor = valor
    }

    override fun toString(): String {
        return "${this.descricao} - R$ ${this.valor}"
    }

}
