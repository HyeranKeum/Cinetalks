package com.cinetalks.movie_review_service.domain.entity

import jakarta.persistence.*

@Entity
class Review(
    member: Member,
    movie: Movie,
    rating: Double,
    comment: String?,
    isActive: Boolean
) : BaseEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    var id: Long? = null

    @ManyToOne(targetEntity = Member::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var member: Member = member

    @ManyToOne(targetEntity = Movie::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    var movie: Movie = movie

    var rating: Double = rating

    var comment: String? = comment

    var isActive: Boolean = isActive


}