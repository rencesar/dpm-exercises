package com.example.deuruim

class Cadastro (val lista : ArrayList<Evento> = ArrayList()) {

    fun add(evento : Evento) {
        lista.add(evento)
    }

    fun get() : ArrayList<Evento> {
        return lista
    }

    fun count() : Int {
        return lista.size
    }
}