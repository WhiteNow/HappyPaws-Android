package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Pet

class PetsResponse (val success: Boolean, val pets: ArrayList<Pet>){
    constructor(): this(false, ArrayList<Pet>())
}