package edu.bo.framework.apidata

import edu.bo.data.IRemoteDataSource
import edu.bo.domain.Movie

class MovieDataSource(val apiRest: RetrofitBuilder, val apiKey: String): IRemoteDataSource {
    override suspend fun getPopularMovies(): List<Movie> {
        val response = RetrofitBuilder.apiService.listPopularMovies(apiKey)
            .results.map{
                it.toDomainMovie()
            }
        return response
    }
}

