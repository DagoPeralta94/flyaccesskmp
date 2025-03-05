package com.jda.flyaccesskmp.register

import androidx.lifecycle.ViewModel
import com.jda.flyaccesskmp.register.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    fun registerUser(user: User) {
        _user.value = user
    }
}