package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Promo

class AdsResponse(val success: String, val advertisements: ArrayList<Promo>) {
    constructor(): this("", ArrayList())
}