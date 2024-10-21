package com.cinetalks.movie_review_service.admin.context.movie.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import java.nio.charset.StandardCharsets
import org.json.JSONObject
import org.json.JSONArray

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("[API 컨트롤러(movie) 테스트]")
class AdminMovieApiControllerTest(
    @Autowired private val mockMvc: MockMvc
) {

    private fun performPost(uri: String, content: String): MvcResult {
        return mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
        ).andReturn()
    }

    private fun performPut(uri: String, content: String): MvcResult {
        return mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
        ).andReturn()
    }

    private fun performDelete(uri: String): MvcResult {
        return mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete(uri)
        ).andReturn()
    }

    @Test
    @DisplayName("삽입 테스트")
    fun insertMovieTest() {
        // given
        val uri = "/admin/api/movies"
        val movieJson = """
            {
                "title": "Test Movie",
                "releasedYear": 2024,
                "releasedMonth": 1,
                "releasedDate": 1,
                "director": "Test Director",
                "duration": 120,
                "description": "Test Description",
                "isActive": true
            }
        """.trimIndent()

        // when
        val mvcResult = performPost(uri, movieJson)

        // then
        val getAllMoviesResult = mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/api/v1/movies")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn()
        val allMoviesResponseContent = getAllMoviesResult.response.getContentAsString(StandardCharsets.UTF_8)
        val allMoviesJsonArray = JSONArray(allMoviesResponseContent)
        assertThat(allMoviesJsonArray.length()).isEqualTo(11)
    }

    @Test
    @DisplayName("수정 테스트")
    fun updateMovieTest() {
        // given
        val uri = "/admin/api/movies/1"
        val movieJson = """
            {
                "title": "Updated Movie",
                "releasedYear": 2024,
                "releasedMonth": 1,
                "releasedDate": 2,
                "director": "Updated Director",
                "duration": 130,
                "description": "Updated Description",
                "isActive": true
            }
        """.trimIndent()

        // when
        val mvcResult = performPut(uri, movieJson)

        // then
        val getMovieResult = mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/api/v1/movies/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn()
        val responseContent = getMovieResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonResponse = JSONObject(responseContent)
        assertThat(jsonResponse.getString("title")).isEqualTo("Updated Movie")
    }

    @Test
    @DisplayName("삭제 테스트")
    fun deleteMovieTest() {
        // given
        val uri = "/admin/api/movies/3"

        // when
        val mvcResult = performDelete(uri)

        // then
        val getMovieResult = mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/api/v1/movies/3")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn()
        assertThat(getMovieResult.response.status).isEqualTo(HttpStatus.NOT_FOUND.value())
    }
}
