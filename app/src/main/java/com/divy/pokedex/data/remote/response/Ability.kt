package com.divy.pokedex.data.remote.response

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)