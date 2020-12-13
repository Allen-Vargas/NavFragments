package edu.bo.navfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import edu.bo.data.MovieRepository
import edu.bo.domain.Movie
import edu.bo.framework.firebasedata.MovieDataFirebase
import edu.bo.navfragments.R
import edu.bo.usescases.AddNewMovie
import kotlinx.android.synthetic.main.fragment_add_post.*

/**
 * A simple [Fragment] subclass.

 */
class AddPostFragment : Fragment() {
    private val database = Firebase.database

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myRef = database.getReference("movies")


        txtAddPost.setOnClickListener{
            Toast.makeText(context,"Welcome to Add Post", Toast.LENGTH_SHORT).show()
        }

        saveButton.setOnClickListener {
            val title = editTxtTitleMovieAdd.text
            val posterPath = editTxtUrlPosterAdd.text
            val movie = Movie(title.toString(), posterPath.toString())

            //CASO DE USO
            Toast.makeText(context," Añadiste: ${movie.title}, ${movie.posterPath}", Toast.LENGTH_SHORT).show()
            myRef.child(myRef.push().key.toString()).setValue(movie)
            //AddNewMovie(MovieRepository(MovieDataFirebase()), movie)

            //CLEAR
            editTxtTitleMovieAdd.text.clear()
            editTxtDirectorMovieAdd.text.clear()
            editTxtUrlPosterAdd.text.clear()
        }
    }
}