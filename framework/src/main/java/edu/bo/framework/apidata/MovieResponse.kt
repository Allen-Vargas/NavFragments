package edu.bo.framework.apidata

import edu.bo.framework.apidata.server.Movie

class MovieResponse(val page: Int, val results: List<Movie>)