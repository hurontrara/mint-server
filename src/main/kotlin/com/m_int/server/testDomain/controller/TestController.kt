package com.m_int.server.testDomain.controller

import com.m_int.server.testDomain.dto.TestDTO
import com.m_int.server.testDomain.service.TestService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/test")
class TestController (val testService: TestService) {

    @PostMapping
    fun addTestEntity(@RequestBody @Valid testDTO: TestDTO) : ResponseEntity<TestDTO> {

        return ResponseEntity.status(HttpStatus.CREATED).body(testService.addTestEntity(testDTO))


    }


}
