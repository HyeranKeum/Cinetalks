package com.cinetalks.movie_review_service.admin.context.movie.controller

import com.cinetalks.movie_review_service.admin.context.movie.form.MovieForm
import com.cinetalks.movie_review_service.admin.context.movie.service.AdminMovieService
import com.cinetalks.movie_review_service.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/movies")
class AdminMovieApiController(
    private val adminMovieService: AdminMovieService
) {
    @PostMapping
    fun postMovie(@RequestBody @Validated form: MovieForm): ResponseEntity<Any> {
        adminMovieService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putMovie(@PathVariable id: Long, @RequestBody form: MovieForm): ResponseEntity<Any> {
        adminMovieService.update(id, form)
        return ApiResponse.successCreate()
    }
    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: Long): ResponseEntity<Any> {
        adminMovieService.delete(id)
        return ApiResponse.successDelete()
    }

}