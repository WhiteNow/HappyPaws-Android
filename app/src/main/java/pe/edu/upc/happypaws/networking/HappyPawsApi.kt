package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Pet

class HappyPawsApi {
    companion object {
        val BASE_URL = "https://happypaws-api.herokuapp.com/api"
        val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXNzaW9uIjp7ImlkIjoiNWNlYjI0MTEzZmE4NTYwMDE3ODcxOWY1IiwidGltZXN0YW1wIjoxNTU5MjM0MDIwNzYyfSwiaWF0IjoxNTU5MjM0MDIwLCJleHAiOjE1NTk0MTQwMjB9.9dBHui2Qwnr8E2rkWnPRcpjCIdqnocH7ERlF0aDT8Ns"

        fun petsUrl(): String {
            return "${BASE_URL}/pets"
        }
    }
}