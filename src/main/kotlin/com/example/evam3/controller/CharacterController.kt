package com.example.evam3.controller

import com.example.evam3.entity.Character
import com.example.evam3.entity.Film
import com.example.evam3.service.CharacterService
import com.example.evam3.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

 // Asegúrate de importar tu clase Character

@RestController
@RequestMapping("/character")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class CharacterController {
    @Autowired
    lateinit var characterService: CharacterService

    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(characterService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody character: Character): ResponseEntity<*> {
        return ResponseEntity<Character>(characterService.save(character), HttpStatus.CREATED)
    }

    @PutMapping
    fun update (@RequestBody character: Character):ResponseEntity<Character>{
        return ResponseEntity(characterService.update(character), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return characterService.delete(id)
    }
}