package edu.bo.navfragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import edu.bo.navfragments.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // SET UP
        setup()
    }

    private fun setup(){
        title = "Autentificacion"
        btnRegistrar.setOnClickListener{
            if (editTxtEmail.text.isNotEmpty() && editTxtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTxtEmail.text.toString(),
                    editTxtPassword.text.toString())
                    .addOnCompleteListener{
                    if( it.isSuccessful){
                        showHome(it.result?.user?.email ?:"", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }
        }

        btnAcceder.setOnClickListener{
            if (editTxtEmail.text.isNotEmpty() && editTxtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTxtEmail.text.toString(),
                    editTxtPassword.text.toString())
                    .addOnCompleteListener{
                        if( it.isSuccessful){
                            showHome(it.result?.user?.email ?:"", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autentificar")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType){
        val homeIntent: Intent = Intent(this, RegisterActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}