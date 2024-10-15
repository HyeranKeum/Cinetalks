package com.cinetalks.movie_review_service.presentation.repository

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.domain.entity.Introduction
import com.cinetalks.movie_review_service.domain.entity.Member
import com.cinetalks.movie_review_service.domain.entity.Movie
import com.cinetalks.movie_review_service.domain.repository.IntroductionRepository
import com.cinetalks.movie_review_service.domain.repository.MemberRepository
import com.cinetalks.movie_review_service.domain.repository.MovieRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PresentationRepository(
    private val introductionRepository: IntroductionRepository,
    private val memberRepository: MemberRepository,
    private val movieRepository: MovieRepository,
) {

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

    fun getMoviesById(id: Long): Optional<Movie> {
        return movieRepository.findById(id)
    }

    fun getMembersById(id: Long): Optional<Member> {
        return memberRepository.findById(id)
    }


}