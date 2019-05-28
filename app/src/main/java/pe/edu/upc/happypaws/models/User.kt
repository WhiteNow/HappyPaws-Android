package pe.edu.upc.happypaws.models

data class User(
    val _id: String,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String
) {
    constructor(): this("","","","","")
}