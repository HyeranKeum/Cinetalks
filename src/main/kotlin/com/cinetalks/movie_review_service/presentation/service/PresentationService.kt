package com.cinetalks.movie_review_service.presentation.service

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.presentation.dto.IntroductionDTO
import com.cinetalks.movie_review_service.presentation.dto.MemberDTO
import com.cinetalks.movie_review_service.presentation.dto.MovieDTO
import com.cinetalks.movie_review_service.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()

        return introductions.map { IntroductionDTO(it) }

    }

    fun getMembers(): List<MemberDTO> {
        val members = presentationRepository.getActiveMembers()

        return members.map { MemberDTO(it) }

    }

    fun getMovies(): List<MovieDTO> {
        val movies = presentationRepository.getActiveMovies()

        return movies.map { MovieDTO(it) }

    }

    fun getMoviesById(id: Long): Optional<MovieDTO> {
        val movies = presentationRepository.getMoviesById(id)
        return movies.map { MovieDTO(it) }
    }

    fun getMoviesByGenre(genre: Genre): List<MovieDTO> {
        val moviesByGenre = presentationRepository.getMoviesByGenre(genre)
        return moviesByGenre.map { MovieDTO(it) }
    }

    /*    fun getReview(): List<ReviewDTO1> {
            val reviews = presentationRepository.getActiveReviews()

            return reviews.map{ReviewDTO(it)}

        }*/
}