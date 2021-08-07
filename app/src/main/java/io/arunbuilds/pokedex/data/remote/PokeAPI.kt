package io.arunbuilds.pokedex.data.remote

import io.arunbuilds.pokedex.data.remote.responses.Pokemon
import io.arunbuilds.pokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeAPI {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList


    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") pokemonName: String,
    ): Pokemon

}