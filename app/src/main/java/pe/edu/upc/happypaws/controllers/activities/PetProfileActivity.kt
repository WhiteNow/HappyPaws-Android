package pe.edu.upc.happypaws.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_pet_profile.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.models.Pet

class PetProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_profile)

        intent.extras.apply {
            var pet = getParcelable("pet") as Pet
            Log.i("Pets", pet.name)

//            if (pet != null) {
//                textViewAge.text = "6"
//                textViewName.text = pet.name
//                textViewPetName.text = pet.name
//                textViewCirugia.text = pet.surgery
//                textViewWeigth.text = pet.weight
//                textViewDisease.text = pet.desease
//            }

        }
    }


}
