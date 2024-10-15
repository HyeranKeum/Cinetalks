package com.cinetalks.movie_review_service.presentation.controller

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.domain.entity.Member
import com.cinetalks.movie_review_service.presentation.dto.IntroductionDTO
import com.cinetalks.movie_review_service.presentation.dto.MemberDTO
import com.cinetalks.movie_review_service.presentation.dto.MovieDTO
import com.cinetalks.movie_review_service.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String{
        return "OK"
    }
    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO>{
        return presentationService.getIntroductions()
    }
    @GetMapping("/v1/members")
    fun getMembers(): List<MemberDTO>{
        return presentationService.getMembers()
    }
    @GetMapping("/v1/movies")
    fun getMovies(): List<MovieDTO>{
        return presentationService.getMovies()
    }

/*
    // 특정 장르 영화 모두 출력
    @GetMapping("/v1/movies/{genre_id}")
    fun getMoviesByGenre(@PathVariable genre_id: Genre): List<MovieDTO>{
        return presentationService.getMoviesByGenre(genre_id)
    }
*/

}