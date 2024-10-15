package com.cinetalks.movie_review_service.presentation.repository

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.domain.entity.*
import com.cinetalks.movie_review_service.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val introductionRepository: IntroductionRepository,
    private val memberRepository: MemberRepository,
    private val movieRepository: MovieRepository,
    private val reviewRepository: ReviewRepository,
    private val movieGenreRepository: MovieGenreRepository
) {
    // 장르가 되는지 확인 ->
    fun getActiveIntroductions(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveMembers(): List<Member> {
        return memberRepository.findAllByIsActive(true)
    }

    fun getActiveMovies(): List<Movie> {
        return movieRepository.findAllByIsActive(true)
    }

    fun getMoviesByGenre(genre: Genre): List<Movie> {
        return movieRepository.findByGenreId(genre)
    }

    fun getActiveReviews(): List<Review> {
        return reviewRepository.findAllByIsActive(true)
    }

}