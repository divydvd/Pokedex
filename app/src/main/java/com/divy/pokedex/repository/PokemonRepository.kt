package com.divy.pokedex.repository

import com.divy.pokedex.data.remote.PokeApi
import com.divy.pokedex.data.remote.response.Pokemon
import com.divy.pokedex.data.remote.response.PokemonList
import com.divy.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: java.lang.Exception){
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: java.lang.Exception){
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }
}