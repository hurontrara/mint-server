package com.m_int.server.testDomain.dto

import jakarta.validation.constraints.NotBlank

data class TestDTO (

    val id : Long?,

    @get:NotBlank(message = "TestDTO.name must not be blank")
    val name: String

)