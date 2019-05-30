package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Pet

class HappyPawsApi {
    companion object {
        val BASE_URL = "https://happy-paws-api.herokuapp.com/api"
        val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXNzaW9uIjp7ImlkIjoiNWNlYjI0MTEzZmE4NTYwMDE3ODcxOWY1IiwidGltZXN0YW1wIjoxNTU5MDgzNTEyNzA4fSwiaWF0IjoxNTU5MDgzNTEyLCJleHAiOjE1NTkyNjM1MTJ9.Ff-2T-oRWPsz8JR1j87Z_cJ56eVk7ZV5xNlwmSzkmKo"

        fun petsUrl(): String {
            return "${BASE_URL}/pets"
        }

        fun adsUrl(): String {
            return "${BASE_URL}/advertisements"
        }
        fun signIn(): String {
            return "${BASE_URL}/account/signin"
        }

    }
}