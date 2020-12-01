package edu.bo.framework.apidata

import edu.bo.domain.Movie as DomainMovie
import edu.bo.framework.apidata.server.Movie as ServerMovie

fun ServerMovie.toDomainMovie(): DomainMovie {
    return DomainMovie(title,posterPath)
}