package com.m_int.server.testDomain.entity

import jakarta.persistence.*


@Entity
@Table(name = "TEST_TABLE")
class TestEntity (

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "my_seq_gen", sequenceName = "my_sequence", initialValue = 1, allocationSize = 1)
    val id: Long?,

    var name: String

)
