package com.cinetalks.movie_review_service.domain.entity

import com.cinetalks.movie_review_service.domain.constant.Genre
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Movie(
    title: String,
    releasedDate: LocalDate,
    director: String,
    duration: Int,
    description: String,
    isActive: Boolean
) : BaseEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    var id: Long? = null

    var title: String = title

    var releasedDate: LocalDate = releasedDate

    var director: String = director

    var description: String = description

    var duration: Int = duration

    //영화 - 장르 양방향
    @OneToMany(
        mappedBy = "movie",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    ) // 양방향 연관관계에서 연관관계 주인 지정
    var genres: MutableList<MovieGenre> = mutableListOf()


    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var reviews: MutableList<Review> = mutableListOf()

    var isActive: Boolean = isActive

}