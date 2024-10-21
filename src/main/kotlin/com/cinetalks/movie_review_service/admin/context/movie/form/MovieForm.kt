package com.cinetalks.movie_review_service.admin.context.movie.form

import com.cinetalks.movie_review_service.domain.entity.Movie
import jakarta.validation.constraints.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class MovieForm(
    @field:NotBlank(message = "필수값입니다.")
    val title: String,

    val releasedYear: Int,

    val releasedMonth: Int,

    val releasedDate: Int,

    @field:NotBlank(message = "필수값입니다.")
    val director: String,

    @field:Min(value = 1, message = "1 이상이어야 합니다.")
    val duration: Int,

    val description: String,

    val isActive: Boolean
) {
    fun toEntity(): Movie {
        val formattedDate = String.format("%d-%02d-%02d", releasedYear, releasedMonth, releasedDate)
        val localDate = LocalDate.parse(formattedDate, DateTimeFormatter.ISO_DATE)

        return Movie(
            title = this.title,
            releasedDate = localDate,
            director = this.director,
            duration = this.duration,
            description = this.description,
            isActive = this.isActive,
        )
    }

    fun toEntity(id: Long): Movie {
        val movie = this.toEntity()
        movie.id = id
        return movie
    }
}
