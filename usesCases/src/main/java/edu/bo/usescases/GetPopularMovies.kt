package edu.bo.usescases

import edu.bo.data.MovieRepository
import edu.bo.domain.Movie

class GetPopularMovies(val moviesRepository: MovieRepository) {
    suspend fun invoke(): List<Movie> = moviesRepository.getPopularMovies()
}