package com.cinetalks.movie_review_service.domain.repository

import com.cinetalks.movie_review_service.domain.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository : JpaRepository<Member, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Member>

    override fun findById(id: Long): Optional<Member>

}