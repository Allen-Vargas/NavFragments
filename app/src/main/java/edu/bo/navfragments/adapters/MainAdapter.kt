package edu.bo.navfragments.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.bo.domain.Movie
import edu.bo.navfragments.R
import edu.bo.navfragments.activities.DetailActivity
import kotlinx.android.synthetic.main.card_movie.view.*

class MainAdapter(val list: List<Movie>): RecyclerView.Adapter<MainAdapter.MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val viewInflater = LayoutInflater.from(parent.context)
        return MovieHolder(viewInflater.inflate(R.layout.card_movie, parent,false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size

    class MovieHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun render(movie: Movie){
            view.card_title_movie.text = movie.title

            //USE CASE MOVIE-DATA-SOURCE
            Picasso.get().load("https://image.tmdb.org/t/p/w185/${movie.posterPath}").into(view.card_img_movie)
            //USE CASE MOVIE-DATA-LOCAL
            //Picasso.get().load(movie.posterPath).into(view.card_img_movie)

            view.setOnClickListener {
                //Toast.makeText(view.context, "Has seleccionado a: ${movie.title}",Toast.LENGTH_SHORT).show()

                val intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("iTitle",movie.title)

                //USE CASE MOVIE-DATA-SOURCE
                intent.putExtra("iImg_URL", "https://image.tmdb.org/t/p/w185/${movie.posterPath}")
                //USE CASE MOVIE-DATA-LOCAL
                //intent.putExtra("iImg_URL", movie.posterPath)
                view.context.startActivity(intent)
            }
        }
    }
}