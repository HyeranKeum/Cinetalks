package com.cinetalks.movie_review_service.admin.context.genre.form

import com.cinetalks.movie_review_service.domain.constant.Genre
import jakarta.validation.constraints.NotBlank

data class GenreForm(
    @field:NotBlank(message = "필수값입니다.")
    val genre: String
) {
    fun toUppercase(): String {
        return genre.uppercase()

    // return Genre.valueOf(genre.uppercase())
    }
}

