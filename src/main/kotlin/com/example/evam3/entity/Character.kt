package com.example.evam3.entity

import jakarta.persistence.*

@Entity
@Table(name = "characters")
class Character {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var actor: String? = null
    var description: String? = null
    var cost: Long? = null
    var stock: Long? = null
    @Column(name = "scene_id")
    var sceneId: Long? = null
}