package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Pet

class HappyPawsApi {
    companion object {

        val BASE_URL = "https://happy-paws-api.herokuapp.com/api"
        val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXNzaW9uIjp7ImlkIjoiNWQxMmVkYTY4NjdlNWEwMDE3MGEzMmI3IiwidGltZXN0YW1wIjoxNTYxNTIxNTkzNjAwfSwiaWF0IjoxNTYxNTIxNTkzLCJleHAiOjE1NjE3MDE1OTN9.ZeegvexWWydUIDaCo9q1SfvLegXghrf6kksY_5hWzW0"


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