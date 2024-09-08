package com.example.roomradar.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.roomradar.R


import com.example.roomradar.navigation.ROUT_ADD_ROOMS
import com.example.roomradar.navigation.ROUT_DETAILS
import com.example.roomradar.navigation.ROUT_HOME

import com.example.roomradar.navigation.ROUT_VIEW_ROOMS
import com.example.roomradar.ui.theme.card2

@Composable
fun DashboardScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {





        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "home",
            modifier = Modifier.size(100.dp), contentScale = ContentScale.Crop

        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Manage your bookings",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif

        )
        Spacer(modifier = Modifier.height(5.dp))

        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            //main card1
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(650.dp),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                colors = CardDefaults.cardColors(card2)) {
                //row1
                Row(modifier = Modifier.padding(20.dp)) {
                    //card2
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp),
                        elevation = CardDefaults.cardElevation(30.dp)) {
                        Column {
                            Spacer(modifier = Modifier
                                .clickable { navController.navigate(ROUT_HOME) }
                                .height(15.dp)
                            )
                            Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                                Image(painter = painterResource(id = R.drawable.img), contentDescription ="",
                                    modifier = Modifier.size(100.dp))

                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "Home",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center)
                        }
                    }//end of card2
                    Spacer(modifier = Modifier.width(20.dp))
                    //card3
                    Card(modifier = Modifier
                        .clickable { navController.navigate(ROUT_DETAILS) }
                        .width(160.dp)
                        .height(180.dp),
                        elevation = CardDefaults.cardElevation(30.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))
                            Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                                Image(painter = painterResource(id = R.drawable.img), contentDescription ="",
                                    modifier = Modifier.size(100.dp))

                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "Property",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center)
                        }
                    }//end of card3

                }
                Spacer(modifier = Modifier.width(20.dp))//end of row1

                //row2


                //row3
                Row(modifier = Modifier.padding(20.dp)) {
                    //card2
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_ADD_ROOMS) },
                        elevation = CardDefaults.cardElevation(30.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))
                            Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                                Image(painter = painterResource(id = R.drawable.img), contentDescription ="",
                                    modifier = Modifier.size(100.dp))

                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "Add Rooms",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center)
                        }
                    }//end of card2
                    Spacer(modifier = Modifier.width(20.dp))
                    //card3
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_VIEW_ROOMS) },
                        elevation = CardDefaults.cardElevation(30.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))
                            Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                                Image(painter = painterResource(id = R.drawable.img), contentDescription ="",
                                    modifier = Modifier.size(100.dp))

                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "View Rooms",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center)
                        }
                    }//end of card3

                }//end of row3


            }//end of main card


        }
        }





    }




@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())
}
