package pe.edu.upc.happypaws.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import pe.edu.upc.happypaws.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)

        }

        register_btn.setOnClickListener {
            val intent = Intent( this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
