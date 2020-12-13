package edu.bo.data

import edu.bo.domain.Movie

interface IRemoteDataSource {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun addNewMovie(movie: Movie)
}