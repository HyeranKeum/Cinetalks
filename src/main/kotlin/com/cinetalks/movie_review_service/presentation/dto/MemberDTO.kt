package com.cinetalks.movie_review_service.presentation.dto

import com.cinetalks.movie_review_service.domain.entity.Member
import java.time.LocalDateTime

class MemberDTO(
    val memberName: String,
    //val reviews: List<ReviewDTO>
) {

    constructor(member: Member) : this(
        memberName = member.memberName,
        //reviews = member.reviews.filter{ it.isActive }.map { ReviewDTO(it) } // 누가 썼는지와 review만,,
    )

}