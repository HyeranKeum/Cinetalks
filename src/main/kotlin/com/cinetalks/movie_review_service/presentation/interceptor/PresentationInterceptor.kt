package com.cinetalks.movie_review_service.presentation.interceptor

import com.cinetalks.movie_review_service.domain.entity.HttpInterface
import com.cinetalks.movie_review_service.domain.repository.HttpInterfaceRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class PresentationInterceptor(
    private val httpInterfaceRepository: HttpInterfaceRepository
) : HandlerInterceptor {

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {

        val httpInterface = HttpInterface(request)
        httpInterfaceRepository.save(httpInterface)
    }
}