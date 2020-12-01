package edu.bo.navfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.bo.data.MovieRepository
import edu.bo.domain.Movie
import edu.bo.framework.apidata.MovieDataSource
import edu.bo.framework.apidata.RetrofitBuilder
import edu.bo.navfragments.adapters.MainAdapter
import edu.bo.navfragments.viewmodels.MainViewModel
import edu.bo.navfragments.R
import edu.bo.usescases.GetPopularMovies
import kotlinx.android.synthetic.main.fragment_home.recyclerView

class HomeFragment : Fragment() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //LAYOUT
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        //CASO DE USO
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