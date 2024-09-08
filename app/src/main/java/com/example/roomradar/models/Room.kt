package com.example.roomradar.models


class Room {
    var name:String = ""
    var location :String= ""
    var price:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, location:String, price: String, imageUrl: String, id: String) {
        this.name = name
        this.location = location
        this.price = price
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}