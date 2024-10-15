package com.cinetalks.movie_review_service.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

class PresentationViewController {

@Controller
    class PresentationApiController {

        @GetMapping("/test")

        fun test(): String{
            return "test"
        }


    }
}