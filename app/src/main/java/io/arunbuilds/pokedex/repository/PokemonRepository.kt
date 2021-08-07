package io.arunbuilds.pokedex.repository

import dagger.hilt.android.scopes.ActivityScoped
import io.arunbuilds.pokedex.data.remote.PokeAPI
import io.arunbuilds.pokedex.data.remote.responses.Pokemon
import io.arunbuilds.pokedex.data.remote.responses.PokemonList
import io.arunbuilds.pokedex.util.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeAPI
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName = pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}