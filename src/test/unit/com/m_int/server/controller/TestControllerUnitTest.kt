package com.m_int.server.controller

import com.m_int.server.testDomain.controller.TestController
import com.m_int.server.testDomain.dto.TestDTO
import com.m_int.server.testDomain.service.TestService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(TestController::class)
@AutoConfigureWebTestClient
class TestControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var testService: TestService

    @Test
    fun addTestEntity() {

        //given
        val request = TestDTO(null, "name10")
        val expectedResponse = TestDTO(10, "name10")

        every { testService.addTestEntity(request) } returns expectedResponse

        //when

        val responseBody = webTestClient
            .post()
            .uri("/api/v1/test")
            .bodyValue(request)
            .exchange()
            .expectStatus().isCreated
            .expectBody(TestDTO::class.java)
            .returnResult()
            .responseBody

        //then

        assertThat(responseBody).isEqualTo(expectedResponse)


    }





}