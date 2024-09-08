package com.example.roomradar.ui.theme.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



import com.example.roomradar.R
import com.example.roomradar.navigation.ROUT_DASHBOARD
import com.example.roomradar.navigation.ROUT_INTENT
import com.example.roomradar.ui.theme.midnight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()){

        TopAppBar(title = { Text(text = "RoomRadar")},
            colors = TopAppBarDefaults.mediumTopAppBarColors(midnight),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(ROUT_DASHBOARD)}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu", tint = Color.Cyan)
                }
            }
        )

        Box(modifier = Modifier.height(168.dp),
            contentAlignment = Alignment.Center) {

            Image(painter = painterResource(id = R.drawable.ht3) , contentDescription = "hotel",
                modifier = Modifier.fillMaxSize())


        }
        Spacer(modifier = Modifier.height(20.dp))

        //Searchbar
        var search by remember { mutableStateOf("") }

        OutlinedTextField(
            value =search ,
            onValueChange = {search = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search")},
            placeholder = { Text(text = "What's your location?")})
        //End of Searchbar
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Card (){
                Box(modifier = Modifier.height(180.dp).width(200.dp),
                    contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(id = R.drawable.ht1) , contentDescription = "hotel",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop)
                }

            }   //Card1

            Spacer(modifier = Modifier.width(20.dp))

            Card (){
                Box(modifier = Modifier.height(180.dp).width(200.dp),
                    contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(id = R.drawable.ht2) , contentDescription = "hotel",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop)
                }

            }
            Spacer(modifier = Modifier.width(20.dp))

            Card (){
                Box(modifier = Modifier.height(180.dp).width(200.dp),
                    contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(id = R.drawable.img) , contentDescription = "hotel",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop)

                }

            }
            Spacer(modifier = Modifier.width(20.dp))

            Card (){
                Box(modifier = Modifier.height(180.dp).width(200.dp),
                    contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(id = R.drawable.img) , contentDescription = "hotel",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop)
                }
            }
            Spacer(modifier = Modifier.width(20.dp))

            Card (){
                Box(modifier = Modifier.height(180.dp).width(200.dp),
                    contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(id = R.drawable.img) , contentDescription = "hotel",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop)
                }
            }

        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = { navController.navigate(ROUT_INTENT) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Continue")

        }




    }


}

@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview(){
    DetailsScreen(rememberNavController())
}

