package com.example.mvvmarchitecture.mvvm.model

/**
 * Data class representing a User.
 * Stores user details for authentication.
 */
data class User(
    val name: String = "",  // User's name
    val email: String = "", // User's email
    val password: String = "" // User's password
)
