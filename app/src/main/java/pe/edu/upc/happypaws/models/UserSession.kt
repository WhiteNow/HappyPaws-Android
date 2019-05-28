package pe.edu.upc.happypaws.models

class UserSession {
    companion object {
        var currentUser: User? = null
        var token: String? = ""
    }
}