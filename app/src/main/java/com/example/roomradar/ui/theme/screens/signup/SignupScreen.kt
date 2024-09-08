package com.example.roomradar.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.roomradar.R

import com.example.roomradar.data.AuthViewModel
import com.example.roomradar.navigation.ROUT_LOGIN
import com.example.roomradar.ui.theme.btn

@Composable
fun SignupScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.bg3
        ),
            contentDescription ="background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
        var name by remember{ mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var pass by remember { mutableStateOf(TextFieldValue("")) }
        var confpass by remember { mutableStateOf(TextFieldValue("")) }
        val context= LocalContext.current
        Column(modifier = Modifier
            .fillMaxSize(),
//            .background(Color.Cyan)
            horizontalAlignment = Alignment.CenterHorizontally) {
            ImageComponent()
            Text(text = "Welcome to Volaire Hotel",
                color = Color.Blue,
                fontFamily = FontFamily.Cursive,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = name, onValueChange = { name = it},
                label = { Text(text = "Name", fontSize = 20.sp)},
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))

            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text(text = "Email", fontSize = 20.sp) },

                keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(value =pass , onValueChange = {pass=it},
                label = { Text(text = "Set password",fontSize = 20.sp) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value =confpass , onValueChange = {
                confpass=it},
                label = { Text(text = "Confirm Password",fontSize = 20.sp) },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))


            Button(onClick = {
                val myregister= AuthViewModel(navController,context)
                myregister.signup(name.text.trim(),email.text.trim(),pass.text.trim(),confpass.text.trim())
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), colors = ButtonDefaults.buttonColors(btn)) {
                Text(text = "Sign Up", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "OR", color = Color.White)

            Button(onClick = {
                navController.navigate(ROUT_LOGIN)
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                colors =ButtonDefaults.buttonColors(btn)) {
                Text(text = "Have an Account? Click to Login")

            }

        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview(){
    SignupScreen(rememberNavController())

}
@Composable
fun ImageComponent(){
    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription ="logo",
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxWidth()
            .height(100.dp))
}