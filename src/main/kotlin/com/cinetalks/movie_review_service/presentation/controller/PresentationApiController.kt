package com.cinetalks.movie_review_service.presentation.controller

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.presentation.dto.IntroductionDTO
import com.cinetalks.movie_review_service.presentation.dto.MemberDTO
import com.cinetalks.movie_review_service.presentation.dto.MovieDTO
import com.cinetalks.movie_review_service.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "OK"
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    //members
    @GetMapping("/v1/members")
    fun getMembers(): List<MemberDTO> {
        return presentationService.getMembers()
    }

    @GetMapping("/v1/members/{memberId}")
    fun getMembersById(@PathVariable memberId: Long): Optional<MemberDTO> {
        return presentationService.getMembersById(memberId)
    }

    //movies
    @GetMapping("/v1/movies")
    fun getMovies(): List<MovieDTO> {
        return presentationService.getMovies()
    }

    @GetMapping("/v1/movies/{movieId}")
    fun getMoviesById(@PathVariable movieId: Long): Optional<MovieDTO> {
        return presentationService.getMoviesById(movieId)
    }

    // genres
    @GetMapping("/v1/genres")
    fun getAllGenres(): List<Genre> {
        return Genre.values().toList()
    }

    @GetMapping("/v1/genres/{genreId}")
    fun getMoviesByGenre(@PathVariable genreId: Int): Optional<MovieDTO> {
        val genre = Genre.fromOrdinal(genreId)
            ?: throw IllegalArgumentException("Invalid genre ID: $genreId")
        return presentationService.getMoviesByGenre(genre)
    }

}