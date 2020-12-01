package edu.bo.data

import edu.bo.domain.Movie

class MovieRepository(val remoteDataSource: IRemoteDataSource) {
    suspend fun getPopularMovies(): List<Movie> = remoteDataSource.getPopularMovies()
}