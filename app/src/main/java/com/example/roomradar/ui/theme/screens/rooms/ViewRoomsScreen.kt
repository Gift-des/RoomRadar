package com.example.roomradar.ui.theme.screens.rooms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


import com.example.roomradar.data.RoomViewModel
import com.example.roomradar.models.Room

@Composable
fun ViewRoomsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var roomRepository = RoomViewModel(navController, context)


        val emptyRoomState = remember { mutableStateOf(Room("","","","","")) }
        var emptyRoomsListState = remember { mutableStateListOf<Room>() }

        var rooms = roomRepository.allRooms(emptyRoomState, emptyRoomsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All rooms",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(rooms){
                    RoomItem(
                        name = it.name,
                        location = it.location,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        roomRepository = roomRepository,
                        roomImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun RoomItem(name:String, location:String, price:String, id:String,
                navController:NavHostController,
                roomRepository:RoomViewModel, roomImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = location)
        Text(text = price)
        Image(
            painter = rememberAsyncImagePainter(roomImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Button(onClick = {
            roomRepository.deleteRoom(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

private fun ColumnScope.rememberAsyncImagePainter(roomImage: String): Painter {
    TODO("Not yet implemented")
}

@Composable
@Preview(showBackground = true)
fun ViewRoomsScreenPreview(){
    ViewRoomsScreen(navController = rememberNavController())

}