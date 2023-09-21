package com.drd.fantasybeerleague.service

import com.drd.fantasybeerleague.model.Player
import com.drd.fantasybeerleague.repository.PlayerRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlayerService(private val repository: PlayerRepository) {

    fun getAllPlayers(): MutableList<Player> = repository.findAll()

    fun getPlayerByPlayerId(playerId: Long) = repository.findById(playerId)

    fun create(player: Player): Player = repository.save(player)

    fun remove(playerId: Long) {
        if (repository.existsById(playerId)) repository.deleteById(playerId)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, player: Player): Player {
        return if (repository.existsById(id)) {
            repository.save(player)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}