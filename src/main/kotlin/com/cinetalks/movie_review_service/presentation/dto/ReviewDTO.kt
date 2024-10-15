package com.cinetalks.movie_review_service.presentation.dto

import com.cinetalks.movie_review_service.domain.entity.Review

class ReviewDTO(
    val member: String,  // MemberDTO 그대로 사용
    //val movie: MovieDTO,    // MovieDTO 그대로 사용
    val rating: Double,     // Double 그대로 사용
    val comment: String?,   // String
) {
    constructor(review: Review) : this(
        member = MemberDTO(review.member).memberName,
        //movie = MovieDTO(review.movie),
        rating = review.rating,  // 숫자 타입 그대로 사용
        comment = review.comment,
    )
}
