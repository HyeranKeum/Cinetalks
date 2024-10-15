package com.cinetalks.movie_review_service.domain.repository

import com.cinetalks.movie_review_service.domain.entity.HttpInterface
import com.cinetalks.movie_review_service.domain.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
}