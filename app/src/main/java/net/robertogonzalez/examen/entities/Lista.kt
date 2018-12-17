package net.robertogonzalez.examen.entities

open class Lista {

    var idLista: Int? = 0
    var nombre: String? = ""
    var idPokemon: Int? = 0
    var idTipo: Int? = 0
    var idHabilidad: Int? = 0
    var estado: Int = 1


    constructor(
        idLista: Int?,
        nombre: String?,
        idPokemon: Int?,
        idTipo: Int?,
        idHabilidad: Int?,
        estado: Int
    ) {
        this.idLista = idLista
        this.nombre = nombre
        this.idPokemon = idPokemon
        this.idTipo = idTipo
        this.idHabilidad = idHabilidad
        this.estado = estado
    }

    constructor()
}