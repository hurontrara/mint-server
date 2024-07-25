package com.m_int.server.controller

import com.m_int.server.testDomain.dto.TestDTO
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient // testImpl -> webflux
@Transactional
class TestControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun addTestEntity() {

        // TODO() : RANDOM_PORT 때문에 롤백이 안되는 상황 ==> 추후 코드 개선 필요

        //given
        val request = TestDTO(null, "name10")

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
        assertThat(responseBody!!.id).isNotNull()

    }

    @Test
    fun addTestEntityFailByValid() {

        //given
        val request = TestDTO(null, "")

        //when
        webTestClient
            .post()
            .uri("api/v1/test")
            .bodyValue(request)
            .exchange()
            .expectStatus().isBadRequest
            .expectBody()
            .jsonPath("$[0]").isEqualTo("TestDTO.name must not be blank")

        //then


    }





}