package com.cinetalks.movie_review_service.presentation.dto

import com.cinetalks.movie_review_service.domain.entity.Introduction

class IntroductionDTO(val content: String) {

    constructor(introduction: Introduction) :
            this(
                content = introduction.content
            )
}