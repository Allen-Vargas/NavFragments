package edu.bo.navfragments.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.bo.domain.Movie
import edu.bo.usescases.GetPopularMovies
import kotlinx.coroutines.launch

class MainViewModel(private val popularMovies: GetPopularMovies): ScopedViewModel() {
    init {
        initScope()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() = _model

    sealed class UiModel {
        class Content(val movies: List<Movie>) : UiModel()
    }

    fun loadMovies(){
        launch {
            _model.value = UiModel.Content(popularMovies.invoke())
        }
    }
}