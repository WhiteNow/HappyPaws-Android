package pe.edu.upc.happypaws.controllers.activities

import pe.edu.upc.happypaws.R

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_pet.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.controllers.adapters.PetPagerAdapter
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep1
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep2
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep3


class NewPetActivity : AppCompatActivity(), NewPetStep1.OnFragmentInteractionListener, NewPetStep2.OnFragmentInteractionListener, NewPetStep3.OnFragmentInteractionListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pet)

        val fragmentAdapter = PetPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

}
