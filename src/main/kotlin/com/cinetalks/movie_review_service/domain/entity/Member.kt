package com.cinetalks.movie_review_service.domain.entity

import com.cinetalks.movie_review_service.domain.constant.Role
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Member(
    memberName: String,
    lastLogin: LocalDateTime?,
    email: String,
    role: String,
    isActive: Boolean
    ) : BaseEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long? = null

    var memberName: String = memberName

    var lastLogin: LocalDateTime? = lastLogin

    var email: String = email

    @Enumerated(EnumType.STRING)
    var role: Role = Role.valueOf(role)

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var reviews: MutableList<Review> = mutableListOf()

    var isActive: Boolean = isActive
}