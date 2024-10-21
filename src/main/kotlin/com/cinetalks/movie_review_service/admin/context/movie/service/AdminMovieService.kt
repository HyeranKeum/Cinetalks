package com.cinetalks.movie_review_service.admin.context.movie.service

import com.cinetalks.movie_review_service.admin.context.movie.form.MovieForm
import com.cinetalks.movie_review_service.domain.repository.MovieRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminMovieService(
    private val movieRepository: MovieRepository
) {
    @Transactional
    fun save(form: MovieForm) {
        val movie = form.toEntity()
        movieRepository.save(movie)
    }

    // 수정
    @Transactional
    fun update(id: Long, form: MovieForm) {
        val movie = form.toEntity(id)
        movieRepository.save(movie)
    }

    //삭제
    @Transactional
    fun delete(id: Long) {
        movieRepository.deleteById(id)
    }


}