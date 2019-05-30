package pe.edu.upc.happypaws.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_sign_in.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.models.User
import pe.edu.upc.happypaws.models.UserSession
import pe.edu.upc.happypaws.networking.HappyPawsApi
import pe.edu.upc.happypaws.networking.UserResponse

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        buttonLogin.setOnClickListener {
            val account = editTextAccount.text.toString()
            val password = editTextPasswordIn.text.toString()
            signIn(account, password)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun signIn(email: String, password: String) {

        if( !email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            Log.i("Jacobo", email)
            Log.i("Jacobo", password)
            AndroidNetworking.post(HappyPawsApi.signIn()).addHeaders("Content-type", "application/json")
                .addBodyParameter("email", email)
                .addBodyParameter("password", password)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(UserResponse::class.java, object: ParsedRequestListener<UserResponse>{

                    override fun onResponse(response: UserResponse?) {
                        response?.apply {
                            success.apply {
                                Log.i("Jacobo", "Status: ${success}")
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
                        Log.e("Jacobo", anError?.message.toString())
                    }
                })
        }

    }
}
