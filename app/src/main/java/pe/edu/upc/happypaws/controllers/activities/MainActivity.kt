package pe.edu.upc.happypaws.controllers.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.controllers.fragments.MenuFragment
import pe.edu.upc.happypaws.controllers.fragments.ProfileFragment
import pe.edu.upc.happypaws.controllers.fragments.StoreFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
      navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigateTo(navigation.menu.findItem(R.id.navigation_profile))

    }

    private fun getFragmentFor(item: MenuItem) : Fragment {
        when (item.itemId) {
            R.id.navigation_profile -> {
                return ProfileFragment()
            }
            R.id.navigation_menu -> {
                return MenuFragment()
            }
            R.id.navigation_store -> {
                return StoreFragment()
            }
        }
        return ProfileFragment()
    }

    private fun navigateTo(item: MenuItem) : Boolean {
        item.isChecked = true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, getFragmentFor(item))
            .commit() > 0
    }

}
