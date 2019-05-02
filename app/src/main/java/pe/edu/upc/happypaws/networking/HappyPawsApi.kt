package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Pet

class HappyPawsApi {
    companion object {
        val BASE_URL = "https://happypaws-api.herokuapp.com/api"
        val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXNzaW9uIjp7ImlkIjoiNWNiNjNmYWJkNmQ0YmYwMDE3YThkYzk1IiwidGltZXN0YW1wIjoxNTU2Nzc5NTMwODk5fSwiaWF0IjoxNTU2Nzc5NTMwLCJleHAiOjE1NTY3ODEzMzB9.kX3svIq57IZCm1Pv0ymiGj-hj06wTCq11yeZNFVYOcQ"

        fun petsUrl(): String {
            return "${BASE_URL}/pets"
        }
    }
}