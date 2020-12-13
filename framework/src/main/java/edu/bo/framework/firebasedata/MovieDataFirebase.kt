package edu.bo.framework.firebasedata

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import edu.bo.data.IRemoteDataSource
import edu.bo.domain.Movie

class MovieDataFirebase: IRemoteDataSource {
    private val listMovies: ArrayList<Movie> = ArrayList()
    private val database = Firebase.database
    private val myRef = database.getReference("movies")
    private lateinit var messagesListener: ValueEventListener

    override suspend fun getPopularMovies(): List<Movie> {

        messagesListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.children.forEach { child ->
                    val movie: Movie? =
                            Movie(  child.child("title").getValue<String>(),
                                    child.child("posterPath").getValue<String>())
                    movie?.let { listMovies.add(it)}
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRef.addValueEventListener(messagesListener)
        return listMovies
    }

    override suspend fun addNewMovie(movie: Movie) {
        myRef.child(myRef.push().key.toString()).setValue(movie)
    }
}