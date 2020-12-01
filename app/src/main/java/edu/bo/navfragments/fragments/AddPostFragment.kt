package edu.bo.navfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import edu.bo.navfragments.R
import kotlinx.android.synthetic.main.fragment_add_post.*

/**
 * A simple [Fragment] subclass.

 */
class AddPostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtAddPost.setOnClickListener{
            Toast.makeText(context,"Welcome to Add Post", Toast.LENGTH_SHORT).show()
        }
    }
}