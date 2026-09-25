package com.example.miprimeraaplicacion.ui

import android.R.attr.checked
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miprimeraaplicacion.ui.theme.MiPrimeraAplicacionTheme

@Composable
@Preview
fun TipCalculatorScreenPreview(){
    MiPrimeraAplicacionTheme {
        TipCalculatorScreen()
    }
}

@Composable
fun TipCalculatorScreen() {
    var totalAmount: String by remember { mutableStateOf("") }
    var guestNumberState = remember({ TextFieldState() })
    var sliderPosition: Float by remember { mutableStateOf(0.0F) }
    var checkedState: Boolean by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        innerPadding ->
        val columnModifier = Modifier
            .consumeWindowInsets(innerPadding)
            .padding(innerPadding)
            .fillMaxSize()
        Column(
            modifier = columnModifier,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            var textFieldMod = Modifier.fillMaxWidth()
                .padding(8.dp)
            TextField(
                modifier = textFieldMod,
                value = totalAmount,
                onValueChange = {
                    newText ->
                    totalAmount = newText
                }
            )
            TextField(
                modifier = textFieldMod,
                state = guestNumberState,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Eri gai?")
                Switch(
                    checked = checkedState,
                    onCheckedChange = {
                        checkedState = it
                    }
                )
            }
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..100f,
                steps = 3
            )
            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                onClick = {

                }
            ) {
                Text("CALCULAR")
            }
        }
    }
}