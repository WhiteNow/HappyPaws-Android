package pe.edu.upc.happypaws.controllers.activities


import pe.edu.upc.happypaws.R

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
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
import android.widget.RadioGroup
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.LinearLayout
import android.view.View


class NewPetActivity : AppCompatActivity(),NewPetStep1.OnFragmentInteractionListener, NewPetStep2.OnFragmentInteractionListener, NewPetStep3.OnFragmentInteractionListener{



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
        if (datePickerTextView.text.toString() != "--/--/----" && textWeight.text.toString().isNotEmpty()) {
            viewPager.currentItem = 2
        }
    }

    fun saveAndComplete() {
        if (textVaccines.text.toString().isNotEmpty() && textDisease.text.toString().isNotEmpty() && textSurgeries.text.toString().isNotEmpty()) {
            finish()
        }
    }

    fun swipeLeft() {
        if (viewPager.currentItem > 0) {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    fun createPet(){
        val genderRadioButton = findViewById<RadioButton>(genderRadioGroup.checkedRadioButtonId)
        val speciesRadioButton = findViewById<RadioButton>(speciesRadioGroup.checkedRadioButtonId)
        val pet = Pet("" ,textInputPetName.text.toString(), speciesRadioButton.text.toString(), datePickerTextView.text.toString(), genderRadioButton.text.toString(), textWeight.text.toString(), textVaccines.text.toString(), textDisease.text.toString(), textSurgeries.text.toString(), "" )

    }




}
