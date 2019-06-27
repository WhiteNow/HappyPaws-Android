package pe.edu.upc.happypaws.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_promo.*
import pe.edu.upc.happypaws.R

class PromoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promo)

        intent?.extras?.apply {
            promo_imageview.setImageUrl(getString("url"))
            promo_imageview.setDefaultImageResId(R.drawable.promo_default)
            text_expiration.text = getString("date")
            text_description.text = getString("description")
            text_price.text = getString("price")
            promo_name.text = getString("title")
        }
    }

}
