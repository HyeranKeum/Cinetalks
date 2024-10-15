package com.cinetalks.movie_review_service.domain

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.domain.entity.*
import com.cinetalks.movie_review_service.domain.repository.*
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime

@Component
@Profile(value = ["default"])

class DataInitializer(
    private val movieGenreRepository: MovieGenreRepository,
    private val movieRepository: MovieRepository,
    private val reviewRepository: ReviewRepository,
    private val memberRepository: MemberRepository,
    private val introductionRepository: IntroductionRepository
) {
    val log = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData() {
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        //user 초기화
        val members = mutableListOf<Member>(
            Member(
                memberName =  "김철수",
                lastLogin =  LocalDateTime.of(2024, 1, 24, 15, 20),
                email =  "dummy1@naver.com",
                role = "MEMBER",
                isActive =  true

            ),
            Member(
                memberName =  "이영희",
                lastLogin =  LocalDateTime.of(2024, 8, 30, 1, 12),
                email =  "dummy2@gmail.com",
                role = "MEMBER",
                isActive =  true

            ),
            Member(
                memberName =  "홍길동",
                lastLogin =  LocalDateTime.of(2024, 9, 30, 23 , 32),
                email =  "dummy3@gmail.com",
                role = "MEMBER",
                isActive =  false

            )
        )
        memberRepository.saveAll(members)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고, 해결하는 고양이", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리펙도링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        //movie, movieGenre 초기화
        val movie1 = Movie(
            title = "Inception",
            releasedDate = LocalDate.of(2010, 7, 16),
            director = "Christopher Nolan",
            duration = 148,
            description = "A skilled thief, the absolute best in the dangerous art of extraction.",
            isActive = true
        )

        val movie2 = Movie(
            title = "The Godfather",
            releasedDate = LocalDate.of(1972, 3, 24),
            director = "Francis Ford Coppola",
            duration = 175,
            description = "The aging patriarch of an organized crime dynasty transfers control to his son.",
            isActive = true
        )

        val movie3 = Movie(
            title = "The Dark Knight",
            releasedDate = LocalDate.of(2008, 7, 18),
            director = "Christopher Nolan",
            duration = 152,
            description = "When the menace known as the Joker wreaks havoc on Gotham.",
            isActive = true
        )

        val movie4 = Movie(
            title = "Pulp Fiction",
            releasedDate = LocalDate.of(1994, 10, 14),
            director = "Quentin Tarantino",
            duration = 154,
            description = "The lives of two mob hitmen, a boxer, and a pair of diner bandits intertwine.",
            isActive = true
        )


        val movie5 = Movie(
            title = "The Lord of the Rings: The Return of the King",
            releasedDate = LocalDate.of(2003, 12, 17),
            director = "Peter Jackson",
            duration = 201,
            description = "Gondor calls for aid as Sauron’s forces begin their attack.",
            isActive = true
        )


        val movie6 = Movie(
            title = "Forrest Gump",
            releasedDate = LocalDate.of(1994, 7, 6),
            director = "Robert Zemeckis",
            duration = 142,
            description = "The story of an ordinary man with an extraordinary life.",
            isActive = true
        )


        val movie7 = Movie(
            title = "Fight Club",
            releasedDate = LocalDate.of(1999, 10, 15),
            director = "David Fincher",
            duration = 139,
            description = "An insomniac office worker forms a fight club.",
            isActive = true
        )


        val movie8 = Movie(
            title = "The Matrix",
            releasedDate = LocalDate.of(1999, 3, 31),
            director = "The Wachowskis",
            duration = 136,
            description = "A computer hacker learns the truth about reality.",
            isActive = true
        )


        val movie9 = Movie(
            title = "Interstellar",
            releasedDate = LocalDate.of(2014, 11, 7),
            director = "Christopher Nolan",
            duration = 169,
            description = "A team of explorers travels beyond this galaxy to save humanity.",
            isActive = true
        )


        val movie10 = Movie(
            title = "Gladiator",
            releasedDate = LocalDate.of(2000, 5, 5),
            director = "Ridley Scott",
            duration = 155,
            description = "A Roman general seeks revenge after being betrayed.",
            isActive = true
        )

        movie1.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie1, genre = Genre.SCIENCE_FICTION),
                MovieGenre(movie = movie1, genre = Genre.ACTION),
                MovieGenre(movie = movie1, genre = Genre.THRILLER)
            )
        )

        movie2.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie2, genre = Genre.CRIME),
                MovieGenre(movie = movie2, genre = Genre.DRAMA)
            )
        )

        movie3.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie3, genre = Genre.ACTION),
                MovieGenre(movie = movie3, genre = Genre.CRIME),
                MovieGenre(movie = movie3, genre = Genre.THRILLER)
            )
        )

        movie4.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie4, genre = Genre.CRIME),
                MovieGenre(movie = movie4, genre = Genre.DRAMA),
                MovieGenre(movie = movie4, genre = Genre.THRILLER)
            )
        )

        movie5.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie5, genre = Genre.FANTASY),
                MovieGenre(movie = movie5, genre = Genre.ADVENTURE),
                MovieGenre(movie = movie5, genre = Genre.ACTION)
            )
        )

        movie6.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie6, genre = Genre.DRAMA),
                MovieGenre(movie = movie6, genre = Genre.ROMANCE)
            )
        )

        movie7.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie7, genre = Genre.DRAMA),
                MovieGenre(movie = movie7, genre = Genre.THRILLER)
            )
        )

        movie8.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie8, genre = Genre.SCIENCE_FICTION),
                MovieGenre(movie = movie8, genre = Genre.ACTION),
                MovieGenre(movie = movie8, genre = Genre.THRILLER)
            )
        )

        movie9.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie9, genre = Genre.SCIENCE_FICTION),
                MovieGenre(movie = movie9, genre = Genre.ADVENTURE),
                MovieGenre(movie = movie9, genre = Genre.DRAMA)
            )
        )

        movie10.genres.addAll(
            mutableListOf(
                MovieGenre(movie = movie10, genre = Genre.HISTORICAL),
                MovieGenre(movie = movie10, genre = Genre.ACTION),
                MovieGenre(movie = movie10, genre = Genre.DRAMA)
            )
        )

        movieRepository.saveAll(mutableListOf(
            movie1,
            movie2,
            movie3,
            movie4,
            movie5,
            movie6,
            movie7,
            movie8,
            movie9,
            movie10))

        //review 초기화
        val reviews = mutableListOf<Review>(
            Review(
                member = members[0], // 김철수
                movie = movie1, // Inception
                rating = 4.5,
                comment = "Mind-blowing movie! Loved the concept of dreams within dreams.",
                isActive = true
            ),
            Review(
                member = members[1], // 이영희
                movie = movie2, // The Godfather
                rating = 5.0,
                comment = "One of the greatest movies of all time.",
                isActive = true
            ),
            Review(
                member = members[2], // 홍길동
                movie = movie3, // The Dark Knight
                rating = 4.0,
                comment = "Great action and performances. Heath Ledger was phenomenal!",
                isActive = true
            ),
            Review(
                member = members[0], // 김철수
                movie = movie4, // Pulp Fiction
                rating = 4.5,
                comment = "Tarantino at his best! Intricate storytelling.",
                isActive = true
            ),
            Review(
                member = members[1], // 이영희
                movie = movie5, // The Lord of the Rings: The Return of the King
                rating = 4.0,
                comment = "Epic conclusion to an epic trilogy.",
                isActive = true
            ),
            Review(
                member = members[2], // 홍길동
                movie = movie6, // Forrest Gump
                rating = 5.0,
                comment = "Heartwarming and inspiring. Tom Hanks is brilliant.",
                isActive = true
            ),
            Review(
                member = members[0], // 김철수
                movie = movie7, // Fight Club
                rating = 4.5,
                comment = "Dark, gritty, and thought-provoking.",
                isActive = true
            ),
            Review(
                member = members[1], // 이영희
                movie = movie8, // The Matrix
                rating = 5.0,
                comment = "Groundbreaking visuals and concept. A must-watch!",
                isActive = true
            ),
            Review(
                member = members[2], // 홍길동
                movie = movie9, // Interstellar
                rating = 4.5,
                comment = "A visually stunning exploration of space and time.",
                isActive = true
            ),
            Review(
                member = members[0], // 김철수
                movie = movie3, // The Dark Knight
                rating = 4.5,
                comment = "정말 멋진 액션과 놀라운 연기. 꼭 다시 보고 싶은 영화입니다.",
                isActive = true
            ),
            Review(
                member = members[1], // 이영희
                movie = movie6, // Forrest Gump
                rating = 4.5,
                comment = null,
                isActive = true
            )


        )
        reviewRepository.saveAll(reviews)

    }
}