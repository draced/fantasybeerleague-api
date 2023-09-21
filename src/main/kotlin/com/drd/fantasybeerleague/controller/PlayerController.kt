package com.drd.fantasybeerleague.controller

import com.drd.fantasybeerleague.model.Player
import com.drd.fantasybeerleague.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/players")
class PlayerController(private val service: PlayerService) {

    @GetMapping
    fun getAllPlayers() = service.getAllPlayers()

    @GetMapping("/{playerId}")
    fun getPlayer(@PathVariable playerId: Long) = service.getPlayerByPlayerId(playerId)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePlayer(@RequestBody player: Player): Player = service.create(player)

    @DeleteMapping("/{playerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePlayer(@PathVariable playerId: Long) = service.remove(playerId)

    @PutMapping("/{playerId}")
    fun updatePlayer(
            @PathVariable playerId: Long, @RequestBody player: Player
    ) = service.update(playerId, player)
}