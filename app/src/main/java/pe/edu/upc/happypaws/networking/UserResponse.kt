package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.User

class UserResponse (val success: Boolean, val user: User, val token: String) {
    constructor(): this(false, User(), "")
}