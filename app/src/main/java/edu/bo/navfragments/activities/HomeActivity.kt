package edu.bo.navfragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.bo.data.MovieRepository
import edu.bo.domain.Movie
import edu.bo.framework.localdata.MovieDataLocal
import edu.bo.framework.apidata.MovieDataSource
import edu.bo.framework.apidata.RetrofitBuilder
import edu.bo.navfragments.adapters.MainAdapter
import edu.bo.navfragments.viewmodels.MainViewModel
import edu.bo.navfragments.R
import edu.bo.usescases.GetPopularMovies
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //LAYOUT
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        //USE CASE
        val usesCases = GetPopularMovies(MovieRepository(MovieDataSource(RetrofitBuilder, getString(R.string.api_key))))
        mainViewModel = MainViewModel(usesCases)
        mainViewModel.model.observe(this, Observer(::upadateUi))
        mainViewModel.loadMovies()
    }

    fun upadateUi(model: MainViewModel.UiModel) {
        when(model) {
            is MainViewModel.UiModel.Content -> showList(model.movies)
        }
    }

    private fun showList(list: List<Movie>) {
        recyclerView.adapter = MainAdapter(list)
    }
}