package com.cinetalks.movie_review_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieReviewServiceApplication

fun main(args: Array<String>) {
	runApplication<MovieReviewServiceApplication>(*args)
}
