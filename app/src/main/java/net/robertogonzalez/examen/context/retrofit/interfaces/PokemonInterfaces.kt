package net.robertogonzalez.examen.context.retrofit.interfaces

import net.robertogonzalez.examen.entities.PokemonRespuestaApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonInterfaces {

    @GET("pokemon")
    fun obtenerListaPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<PokemonRespuestaApi>

}