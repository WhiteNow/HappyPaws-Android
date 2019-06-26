package pe.edu.upc.happypaws.controllers.activities


import pe.edu.upc.happypaws.R

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_new_pet.*
import kotlinx.android.synthetic.main.fragment_new_pet_step1.*
import kotlinx.android.synthetic.main.fragment_new_pet_step2.*
import kotlinx.android.synthetic.main.fragment_new_pet_step3.*


import pe.edu.upc.happypaws.adapters.PetPagerAdapter

import pe.edu.upc.happypaws.controllers.fragments.NewPetStep1
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep2
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep3
import pe.edu.upc.happypaws.models.Pet
import android.view.MotionEvent
import android.widget.LinearLayout
import android.view.View
import com.android.volley.toolbox.JsonObjectRequest
import com.androidnetworking.error.ANError
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.interfaces.ParsedRequestListener
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import pe.edu.upc.happypaws.models.UserSession
import pe.edu.upc.happypaws.networking.HappyPawsApi
import pe.edu.upc.happypaws.networking.UserResponse


class NewPetActivity : AppCompatActivity(),NewPetStep1.OnFragmentInteractionListener, NewPetStep2.OnFragmentInteractionListener, NewPetStep3.OnFragmentInteractionListener{


    var genderRadioButtonText = "Masculino"
    var speciesRadioButtonText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pet)

        val fragmentAdapter = PetPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.clearOnTabSelectedListeners()
        val tabStrip = tabLayout.getChildAt(0) as LinearLayout
        for (i in 0 until tabStrip.childCount) {
            tabStrip.getChildAt(i).setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View, event: MotionEvent): Boolean {
                    return true
                }
            })
        }

       /* speciesRadioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            speciesRadioButtonText = radio.text.toString()

        })

        genderRadioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                genderRadioButtonText = radio.text.toString()

            })*/


    }



    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    fun swipeToPage2() {
        if (textInputPetName.text.toString().isNotEmpty() && speciesRadioGroup.checkedRadioButtonId != -1) {
            viewPager.currentItem = 1
        }
    }

    fun swipeToPage3() {
        if (datePickerTextView.text.toString() != "----/--/--" && textWeight.text.toString().isNotEmpty()) {
            viewPager.currentItem = 2
        }
    }

    fun saveAndComplete() {
        if (textVaccines.text.toString().isNotEmpty() && textDisease.text.toString().isNotEmpty() && textSurgeries.text.toString().isNotEmpty()) {
            savePet()
            finish()
        }
    }

    fun swipeLeft() {
        if (viewPager.currentItem > 0) {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    fun createPet(){
        val pet = Pet("" ,textInputPetName.text.toString(), speciesRadioButtonText, datePickerTextView.text.toString(), genderRadioButtonText, textWeight.text.toString(), textVaccines.text.toString(), textDisease.text.toString(), textSurgeries.text.toString(), "5ceb24113fa85600178719f5" )
        Log.d("species",speciesRadioButtonText)
        Log.d("gender", genderRadioButtonText)

        AndroidNetworking.post("https://happy-paws-api.herokuapp.com/api/pets")
            .addHeaders("Content-Type", "application/json")
            .addHeaders("Authorization", HappyPawsApi.API_KEY)
            .addBodyParameter("name", pet.name)
            .addBodyParameter("species", pet.species)
            .addBodyParameter("birthdate", pet.birthdate)
            .addBodyParameter("gender", pet.gender)
            .addBodyParameter("weight", pet.weight)
            .addBodyParameter("disease", pet.disease)
            .addBodyParameter("surgery", pet.surgery)
            .addBodyParameter("vaccination", pet.vaccination)
            .addBodyParameter("owner_id", pet.owner_id)
            .setTag("new pet")
            .setPriority(Priority.LOW)
            .build()
            .getAsObject(UserResponse::class.java, object: ParsedRequestListener<UserResponse>{

                override fun onResponse(response: UserResponse?) {
                    response?.apply {
                        success.apply {
                            Log.i("result", "Status: ${success}")
                        }

                        user.apply {
                            UserSession.currentUser = user
                        }

                        token.apply {
                            UserSession.token = token
                        }
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.e("error", "No se registro el pet")
                }
            })



    }



    fun savePet(){
        val pet = Pet("" ,textInputPetName.text.toString(), speciesRadioButtonText, datePickerTextView.text.toString(), genderRadioButtonText, textWeight.text.toString(), textVaccines.text.toString(), textDisease.text.toString(), textSurgeries.text.toString(), "5ceb24113fa85600178719f5" )
        Log.d("species",speciesRadioButtonText)
        Log.d("gender", genderRadioButtonText)

        val url = "https://happy-paws-api.herokuapp.com/api/pets"
        val jsonBody=JSONObject()
        jsonBody.put("name", pet.name)
        jsonBody.put("species", pet.species )
        jsonBody.put("birthdate", pet.birthdate)
        jsonBody.put("gender", genderRadioButtonText)
        jsonBody.put("weight", pet.weight)
        jsonBody.put("disease", pet.disease )
        jsonBody.put("surgery", pet.surgery)
        jsonBody.put("vaccination", pet.vaccination)
        jsonBody.put("owner_id", "5ceb24113fa85600178719f5")

        val requestBody=jsonBody.toString()

        val reviewRequest = object: JsonObjectRequest(Method.POST, url, null,Response.Listener {
                response ->
            try {

            }catch (e: JSONException){
                Log.d("ERROR", e.localizedMessage)
            }
        },Response.ErrorListener {
                error->
            Log.d("ERROR"," Could not find $error")
        }){
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String,String>()
                headers.put("Authorization", HappyPawsApi.API_KEY)
                return headers
            }
        }
        Volley.newRequestQueue(applicationContext).add(reviewRequest)
    }


}
