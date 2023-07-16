package com.pnj.cropexchange.user

data class User(
    val userId: String,
    val email: String,
    val password: String // Note: Password should be hashed and securely stored
)
