package com.mohsenmashkour.newnavwithargscomposeyt

import kotlinx.serialization.Serializable


@Serializable
data class Languages(
    val id: Int,
    val name: String,
    val usage: String
)

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
