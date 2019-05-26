package pe.edu.upc.happypaws.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep1
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep2
import pe.edu.upc.happypaws.controllers.fragments.NewPetStep3

class PetPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return NewPetStep1()
            }
            1 -> {
                return NewPetStep2()
            }
            2 -> {
                return NewPetStep3()
            }
            else -> return null
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "1"
            1 -> "2"
            else -> {
                return "3"
            }
        }
    }
}