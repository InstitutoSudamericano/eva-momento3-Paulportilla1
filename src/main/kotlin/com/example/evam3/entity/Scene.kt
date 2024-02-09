package com.example.evam3.entity

import jakarta.persistence.*
import java.math.BigDecimal

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException


@Entity
@Table (name="scene")
class Scene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var budget: Double? = null
    @Column(name="cost_of_the_suit")
    var costOfTheSuit: Double? = null
    @Column(name="makeup_cost")
    var makeupCost: Double? = null
    @Column(name="film_id")
    var filmId: Long? = null
}