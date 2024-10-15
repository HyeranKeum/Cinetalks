package com.cinetalks.movie_review_service.presentation.controller

import com.cinetalks.movie_review_service.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
    private val presentationService: PresentationService
) {
    @GetMapping("/test")
    fun test(): String {
        return "test"
    }

    @GetMapping("/")
    fun index(model: org.springframework.ui.Model): String {
        val introductions = presentationService.getIntroductions()
        model.addAttribute("introductions", introductions)

        return "presentation/index" // html 파일 위치를 반환
    }

    /*
        @GetMapping("/reviews")
        fun resume(model: org.springframework.ui.Model): String {

            val resume = presentationService.getResume()
            model.addAttribute("resume", resume)
            model.addAttribute("skillTypes", SkillType.values())

            return "presentation/resume"
        }
    */

}