package com.example.evam3.service


import com.example.evam3.entity.Scene
import com.example.evam3.repository.FilmRepository
import com.example.evam3.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SceneService {
    @Autowired
    lateinit var filmRepository: FilmRepository
    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list ():List<Scene>{
        return sceneRepository.findAll()
    }
    fun save(scene: Scene): Scene {
        try {
            scene.description?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El nombre del actor no debe ser vacío")
            val film = filmRepository.findById(scene.filmId)
                ?: throw Exception("Id del film no encontrados")

            // Ensure cost_of_the_suit and makeup_cost do not exceed the budget
            if (scene.costOfTheSuit!! > scene.budget!! || scene.makeupCost!! > scene.budget!!) {
                throw Exception("Cost_of_the_suit or makeup_cost exceeds the budget")
            }

            // Ensure the budget does not exceed the investment of the film
            if (scene.budget!! > film.investment!!) {
                throw Exception("Scene budget exceeds the film investment")
            }

            return sceneRepository.save(scene)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
    fun update(scene: Scene): Scene {
        try {
            sceneRepository.findById(scene.id)
                ?: throw Exception("ID no existe")

            return sceneRepository.save(scene)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = sceneRepository.findById(id)
                ?: throw Exception("ID no existe")
            sceneRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
            }
        }

}