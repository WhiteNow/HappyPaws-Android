package pe.edu.upc.happypaws.models

import java.util.*

data class Promo(val photo_url: String, val _id: String, val title: String, val description: String,
                 val price: Int, val picture: String, val expirate_date: Date, val pet_shop_id: String) {
    constructor() : this (
        "", "", "", "", 0, "", Date(), "")
}
