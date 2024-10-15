package com.cinetalks.movie_review_service.presentation.controller

import org.assertj.core.api.Assertions.assertThat
import org.json.JSONArray
import org.json.JSONObject
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import java.nio.charset.StandardCharsets

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("[API 컨트롤러 테스트]")
class PresentationApiControllerTest(
    @Autowired private val mockMvc: MockMvc
) {


    @Test
    @DisplayName("members 조회")
    fun testGetMembers() {
        //given
        val uri = "/api/v1/members"

        //when
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonArray = JSONArray(contentAsString)

        //then
        assertThat(jsonArray.length()).isPositive()
    }


    @Test
    @DisplayName("유효한 memberId로 회원 조회")
    fun testGetMemberById_ValidId() {
        //given
        val uri = "/api/v1/members/1"

        //when
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonObject = JSONObject(contentAsString)

        //then
        assertThat(jsonObject.getString("memberName")).isNotBlank()
    }

    @Test
    @DisplayName("범위를 벗어난 memberId로 회원 조회")
    fun testGetMemberById_InvalidId() {
        //given
        val uri = "/api/v1/members/1000"

        //when
        val mvcResult = performGet(uri)
        /*        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
                val jsonArray = JSONArray(contentAsString)*/

        //then
        assertThat(mvcResult.response.status).isEqualTo(HttpStatus.NOT_FOUND.value())
    }

    @Test
    @DisplayName("잘못된 데이터 타입의 memberId로 영화 조회")
    fun testGetMovieById_InvalidDataType() {
        //given
        val uri = "/api/v1/members/abd"

        //when
        val mvcResult = performGet(uri)

        //then
        assertThat(mvcResult.response.status).isEqualTo(HttpStatus.BAD_REQUEST.value())
    }

    @Test
    @DisplayName("movies 조회")
    fun testGetMovies() {
        //given
        val uri = "/api/v1/movies"

        //when
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonArray = JSONArray(contentAsString)

        //then
        assertThat(jsonArray.length()).isPositive()
    }

    @Test
    @DisplayName("유효한 moviesId로 영화 조회")
    fun testGetMovieById_ValidId() {
        //given
        val uri = "/api/v1/movies/10"

        //when
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonObject = JSONObject(contentAsString)

        //then
        assertThat(jsonObject.getString("title")).isNotBlank()  // title은 null이거나 빈 값이면 안 됨
        assertThat(jsonObject.getString("releasedDate")).isNotBlank()  // releasedDate는 null이거나 빈 값이면 안 됨
        assertThat(jsonObject.getString("director")).isNotBlank()  // director는 null이거나 빈 값이면 안 됨
        assertThat(jsonObject.getString("duration")).isNotBlank()  // duration은 null이거나 빈 값이면 안 됨
        assertThat(jsonObject.getString("description")).isNotBlank()  // description은 null이거나 빈 값이면 안 됨

        // genres 배열은 최소 하나 이상의 요소가 있어야 함
        val genres = jsonObject.getJSONArray("genres")
        assertThat(genres.length()).isPositive()  // genres는 최소 1개 이상의 요소가 있어야 함

        // reviews 배열은 0개일 수도 있음, 따라서 길이가 0 이상인지만 확인
        val reviews = jsonObject.getJSONArray("reviews")
        assertThat(reviews.length()).isGreaterThanOrEqualTo(0)

    }

    @Test
    @DisplayName("범위를 벗어난 moviesId로 회원 조회")
    fun testGetMovieById_InValidId() {
        //given
        val uri = "/api/v1/movies/1000"

        //when
        val mvcResult = performGet(uri)
        /*        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
                val jsonArray = JSONArray(contentAsString)*/

        //then
        assertThat(mvcResult.response.status).isEqualTo(HttpStatus.NOT_FOUND.value())
    }

    @Test
    @DisplayName("잘못된 데이터 타입의 movieId로 영화 조회")
    fun testGetMemberById_InValidId() {
        //given
        val uri = "/api/v1/movies/abd"

        //when
        val mvcResult = performGet(uri)

        //then
        assertThat(mvcResult.response.status).isEqualTo(HttpStatus.BAD_REQUEST.value())
    }

    @Test
    @DisplayName("genres 조회")
    fun testGetGenres() {
        //given
        val uri = "/api/v1/genres"

        //when
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonArray = JSONArray(contentAsString)

        //then
        assertThat(jsonArray.length()).isPositive()
    }

    @Test
    @DisplayName("유효한 genresId로 해당 장르 영화 목록 조회")
    fun testGetGenreById_ValidId() {
        //given
        val uri = "/api/v1/genres/4"

        //when
        val mvcResult = performGet(uri)
        /*        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
                val jsonArray = JSONArray(contentAsString)*/

        //then
        assertThat(mvcResult.response.contentAsString).isNotNull()
    }

    @Test
    @DisplayName("범위를 벗어난 genresId로 회원 조회")
    fun testGetGenreById_InValidId() {
        //given
        val uri = "/api/v1/genres/1000"

        //when
        val mvcResult = performGet(uri)
        /*        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
                val jsonArray = JSONArray(contentAsString)*/

        //then
        assertThat(mvcResult.response.status).isEqualTo(HttpStatus.BAD_REQUEST.value())
    }


    private fun performGet(uri: String): MvcResult {
        return mockMvc
            .perform(MockMvcRequestBuilders.get(uri))
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
    }

}