package com.jda.flyaccesskmp.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Button
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RegisterScreen(goToBack: () -> Unit) {
    Scaffold(
        topBar = {
            IconButton(
                modifier = Modifier.padding(start = 8.dp, top = 32.dp),
                onClick = { goToBack() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    RegisterScreenContent()
                }
            }
        }
    )
}

@Composable
fun RegisterScreenContent() {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var institution by remember { mutableStateOf("") }
    var document by remember { mutableStateOf("") }
    var documentInstitution by remember { mutableStateOf("") }
    Text(
        text = "Registro",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = Color(0xFF302277)
    )
    Text(
        text = "Realiza el ingreso de la persona que va a tener acceso a la institucion",
        textAlign = TextAlign.Center,
    )
    OutlinedTextField(
        modifier = Modifier.padding(vertical = 8.dp),
        value = document,
        onValueChange = { document = it },
        label = { Text(text = "Documento") })
    OutlinedTextField(
        modifier = Modifier.padding(vertical = 8.dp),
        value = name,
        onValueChange = { name = it },
        label = { Text(text = "Nombre") })
    OutlinedTextField(
        modifier = Modifier.padding(vertical = 8.dp),
        value = lastName,
        onValueChange = { lastName = it },
        label = { Text(text = "Apellido") })
    OutlinedTextField(
        modifier = Modifier.padding(vertical = 8.dp),
        value = email,
        onValueChange = { email = it },
        label = { Text(text = "Correo electronico") })
    OutlinedTextField(
        modifier = Modifier.padding(vertical = 8.dp),
        value = institution,
        onValueChange = { institution = it },
        label = { Text(text = "Institucion") })
    OutlinedTextField(
        modifier = Modifier.padding(vertical = 8.dp),
        value = documentInstitution,
        onValueChange = { documentInstitution = it },
        label = { Text(text = "Documento de la institucion") })
    Button(modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp), onClick = { }) {
        Text(text = "Registrar")
    }
}

@Preview()
@Composable
fun RegisterScreenPreview() {
    RegisterScreen { }
}