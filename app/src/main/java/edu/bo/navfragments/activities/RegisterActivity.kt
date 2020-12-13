package edu.bo.navfragments.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import edu.bo.navfragments.R
import kotlinx.android.synthetic.main.activity_register.*

enum class ProviderType {
    BASIC,
    GOOGLE
}

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //SETUP
        val bundle=intent.extras
        val email=bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

        //SAVE INFORMATION & DATA
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider)
        prefs.apply()
    }

    private fun setup(email: String, provider: String){
        title = "Inicio"
        txtEmail.text = email
        txtProveedor.text = provider

        btnLogOut.setOnClickListener{
            //DELETE INFORMATION & DATA
            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            //SIGN-OUT
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}