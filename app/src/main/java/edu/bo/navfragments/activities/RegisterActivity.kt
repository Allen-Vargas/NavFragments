package edu.bo.navfragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import edu.bo.navfragments.R
import kotlinx.android.synthetic.main.activity_register.*

enum class ProviderType {
    BASIC
}

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val bundle=intent.extras
        val email=bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")
    }

    private fun setup(email: String, provider: String){
        title = "Inicio"
        txtEmail.text = email
        txtProveedor.text = provider

        btnLogOut.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}