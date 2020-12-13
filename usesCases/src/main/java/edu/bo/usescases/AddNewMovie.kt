package edu.bo.usescases

import edu.bo.data.MovieRepository
import edu.bo.domain.Movie

class AddNewMovie(val moviesRepository: MovieRepository, val movie: Movie) {
    suspend fun invoke() {
        moviesRepository.addNewMovie(movie)
    }
}