package com.jda.flyaccesskmp


import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.jda.flyaccesskmp.core.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}