package edu.bo.navfragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import edu.bo.navfragments.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //CHANGE ACTION BAR
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //DATA INTENT - DATA EXTRA
        val title = intent.getStringExtra("iTitle")
        val imgURL = intent.getStringExtra("iImg_URL")

        //DATA UPDATE
        actionBar.setTitle(title)
        Picasso.get().load(imgURL).into(imgDetail)
        txtNameDetail.text = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}