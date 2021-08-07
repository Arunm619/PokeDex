package io.arunbuilds.pokedex.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.arunbuilds.pokedex.data.remote.PokeAPI
import io.arunbuilds.pokedex.repository.PokemonRepository
import io.arunbuilds.pokedex.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeAPI
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeAPI(): PokeAPI {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(PokeAPI::class.java)
    }
}