
package com.example.roomradar.ui.theme.screens.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.roomradar.data.AuthViewModel
import com.example.roomradar.navigation.ROUT_SIGNUP
import com.example.roomradar.ui.theme.btn
import com.example.roomradar.ui.theme.sign

@Composable
fun LoginScreen(navController: NavController){
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var pass by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(sign),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome Back,", color = Color.White,
            fontFamily = FontFamily.Cursive, fontSize = 50.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = email, onValueChange = {email=it},
            label = { Text(text="Enter Email", fontSize = 20.sp) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = pass, onValueChange ={pass = it},
            label = { Text(text = "Enter Password", fontSize = 20.sp ) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {
            val mylogin= AuthViewModel(navController,context)
            mylogin.login(
                email.text.trim(),
                pass.text.trim()
            )
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Text(text = "Sign In")
        }


        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick ={ navController.navigate(ROUT_SIGNUP)},
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Don't have an account click to Register")
        }

    }


}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}