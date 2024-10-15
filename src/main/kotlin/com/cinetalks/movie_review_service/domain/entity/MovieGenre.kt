package com.cinetalks.movie_review_service.domain.entity

import com.cinetalks.movie_review_service.domain.constant.Genre
import jakarta.persistence.*

@Entity
class MovieGenre(
    movie: Movie,
    genre: Genre,
    //isActive: Boolean
) : BaseEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieGenre_id")
    var id: Long? = null


    @ManyToOne(targetEntity = Movie::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    var movie: Movie = movie

   // @ManyToOne(targetEntity = Genre::class, fetch = FetchType.LAZY)
   // @JoinColumn(name = "genre_id", nullable = false)
   // var genre: Genre = genre
   @Column(name = "genre")
   @Enumerated(value = EnumType.STRING)
   var genre: Genre = genre

    // var isActive: Boolean = isActive


}