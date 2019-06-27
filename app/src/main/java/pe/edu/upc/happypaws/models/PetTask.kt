package pe.edu.upc.happypaws.models

import java.util.*

data class PetTask(val _id: String, val title: String, val description: String,
                 val state: Boolean, val pet_id: String, val date_time: Date) {
    constructor() : this (
        "", "", "", false, "",  Date())
}