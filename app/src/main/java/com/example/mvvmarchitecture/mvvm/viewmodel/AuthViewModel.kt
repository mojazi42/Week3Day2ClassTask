package com.example.mvvmarchitecture.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel for handling authentication logic.
 * Manages sign-in and sign-up validation.
 */
class AuthViewModel : ViewModel() {

    // Holds validation messages to update the UI
    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message

    /**
     * Validates sign-in input.
     * Updates the message state based on validation results.
     */
    fun signIn(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _message.value = "Fields cannot be empty"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _message.value = "Invalid email format"
        } else {
            _message.value = "Sign-in successful"
        }
    }

    /**
     * Validates sign-up input.
     * Ensures all fields are filled, email is valid, and passwords match.
     */
    fun signUp(name: String, email: String, password: String, confirmPassword: String) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            _message.value = "All fields are required"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _message.value = "Invalid email format"
        } else if (password != confirmPassword) {
            _message.value = "Passwords do not match"
        } else {
            _message.value = "Sign-up successful"
        }
    }
}
