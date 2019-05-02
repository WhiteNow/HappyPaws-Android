package pe.edu.upc.happypaws.controllers.activities


import pe.edu.upc.happypaws.R

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_new_pet.*


import pe.edu.upc.happypaws.adapters.PetPagerAdapter

import pe.edu.upc.happypaws.controllers.fragments.NewPetStep1
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep2
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep3


class NewPetActivity : AppCompatActivity(), NewPetStep1.OnFragmentInteractionListener, NewPetStep2.OnFragmentInteractionListener, NewPetStep3.OnFragmentInteractionListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pet)

        val fragmentAdapter = PetPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setupWithViewPager(viewPager)
    }



    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    fun swipeRight() {
        if (viewPager.currentItem < 2) {
            viewPager.currentItem = viewPager.currentItem + 1
        }
    }

    fun swipeLeft() {
        if (viewPager.currentItem > 0) {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }




}
