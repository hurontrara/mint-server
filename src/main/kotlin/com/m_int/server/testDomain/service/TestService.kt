package com.m_int.server.testDomain.service

import com.m_int.server.testDomain.dto.TestDTO
import com.m_int.server.testDomain.entity.TestEntity
import com.m_int.server.testDomain.repositoy.TestRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TestService(val testRepository: TestRepository) {

    fun addTestEntity(testDTO: TestDTO): TestDTO {

        val entity = TestEntity(null, testDTO.name)

        testRepository.save(entity)

        return entity.let { TestDTO(it.id, it.name) }

    }

}