package com.m_int.server.testDomain.repositoy

import com.m_int.server.testDomain.entity.TestEntity
import org.springframework.data.repository.CrudRepository

interface TestRepository : CrudRepository<TestEntity, Long> {


}