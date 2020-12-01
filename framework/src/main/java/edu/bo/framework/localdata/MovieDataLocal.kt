package edu.bo.framework.localdata

import edu.bo.data.IRemoteDataSource
import edu.bo.domain.Movie

class MovieDataLocal: IRemoteDataSource {
    val list: List<Movie> = listOf(
            Movie("Spider-man","https://i.pinimg.com/originals/f3/96/53/f39653ba234c03aa2623dbb531e16414.jpg"),
            Movie("Spider-man 2","https://i.pinimg.com/originals/21/fa/58/21fa582c3b0f50082d0b3a3a50ea5338.jpg"),
            Movie("Spider-man 3","https://i.pinimg.com/originals/6d/84/6e/6d846e7d2456261cdd4c874821a6adc0.jpg"),
    )

    override suspend fun getPopularMovies(): List<Movie> {
        return list
    }
}