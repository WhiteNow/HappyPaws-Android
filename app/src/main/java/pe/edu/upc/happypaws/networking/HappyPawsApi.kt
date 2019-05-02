package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Pet

class HappyPawsApi {
    companion object {
        val BASE_URL = "https://happypaws-api.herokuapp.com/api"
        val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXNzaW9uIjp7ImlkIjoiNWNiNjNmYWJkNmQ0YmYwMDE3YThkYzk1IiwidGltZXN0YW1wIjoxNTU2ODEzMzg4ODE0fSwiaWF0IjoxNTU2ODEzMzg4LCJleHAiOjE1NTY4MTUxODh9.rbPfbncNrlSAiPUPLGaMU3ubXHNtYlA43W7h6bwC3ZU"

        fun petsUrl(): String {
            return "${BASE_URL}/pets"
        }
    }
}