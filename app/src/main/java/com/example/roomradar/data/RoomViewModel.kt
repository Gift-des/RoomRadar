package com.example.roomradar.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList

import androidx.navigation.NavHostController

import com.example.roomradar.models.Room
import com.example.roomradar.navigation.ROUT_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class RoomViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadRoom(name: String, location: String, price: String, phone: String, filePath: Uri){
        val roomId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("rooms/$roomId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var room = Room(name,location,price,imageUrl,roomId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Rooms/$roomId")
                    databaseRef.setValue(room).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allRooms(
        room:MutableState<Room>,
        rooms:SnapshotStateList<Room>):SnapshotStateList<Room>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Rooms")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                rooms.clear()
                for (snap in snapshot.children){
                    var retrievedRoom = snap.getValue(Room::class.java)
                    room.value = retrievedRoom!!
                    rooms.add(retrievedRoom)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return rooms
    }


    fun deleteRoom(roomId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("rooms/$roomId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun updateRoom(id: String) {
        TODO("Not yet implemented")
    }
}