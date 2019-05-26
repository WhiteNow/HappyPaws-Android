package pe.edu.upc.happypaws.networking

import pe.edu.upc.happypaws.models.Pet

class HappyPawsApi {
    companion object {
        val BASE_URL = "https://happypaws-api.herokuapp.com/api"
        val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXNzaW9uIjp7ImlkIjoiNWNiNjNmYWJkNmQ0YmYwMDE3YThkYzk1IiwidGltZXN0YW1wIjoxNTU2ODE2MjEyNjIyfSwiaWF0IjoxNTU2ODE2MjEyLCJleHAiOjE1NTY4MTgwMTJ9.vJjaEom_DjQxTVg_Z4VPbAqw0y0YgKFtoL-8DekNvaw"

        fun petsUrl(): String {
            return "${BASE_URL}/pets"
        }
    }
}