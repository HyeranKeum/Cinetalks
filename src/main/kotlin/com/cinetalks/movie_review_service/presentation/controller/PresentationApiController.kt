package com.cinetalks.movie_review_service.presentation.controller

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.presentation.dto.IntroductionDTO
import com.cinetalks.movie_review_service.presentation.dto.MemberDTO
import com.cinetalks.movie_review_service.presentation.dto.MovieDTO
import com.cinetalks.movie_review_service.presentation.service.PresentationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    /*    @GetMapping("/v1/members/{memberId}")
        fun getMembersById(@PathVariable memberId: Long): Optional<MemberDTO> {
            return presentationService.getMembersById(memberId)
        }*/

    @GetMapping("/v1/members/{memberId}")
    fun getMembersById(@PathVariable memberId: Long): ResponseEntity<MemberDTO> {
        val member = presentationService.getMembersById(memberId)
        return if (member.isPresent) {
            ResponseEntity.ok(member.get())
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    //movies
    @GetMapping("/v1/movies")
    fun getMovies(): List<MovieDTO> {
        return presentationService.getMovies()
    }

    /*
        @GetMapping("/v1/movies/{movieId}")
        fun getMoviesById(@PathVariable movieId: Long): Optional<MovieDTO> {
            return presentationService.getMoviesById(movieId)
        }
    */

    @GetMapping("/v1/movies/{movieId}")
    fun getMoviesById(@PathVariable movieId: Long): ResponseEntity<MovieDTO> {
        val movie = presentationService.getMoviesById(movieId)
        return if (movie.isPresent) {
            ResponseEntity.ok(movie.get())
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    // genres
    @GetMapping("/v1/genres")
    fun getAllGenres(): List<Genre> {
        return Genre.values().toList()
    }

    @GetMapping("/v1/genres/{genreId}")
    fun getMoviesByGenre(@PathVariable genreId: Int): List<MovieDTO> {
        val genre = Genre.fromOrdinal(genreId)
            ?: throw IllegalArgumentException("Invalid genre ID: $genreId")
        return presentationService.getMoviesByGenre(genre)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleInvalidGenreId(ex: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity("Error: ${ex.message}", HttpStatus.BAD_REQUEST)
    }
}