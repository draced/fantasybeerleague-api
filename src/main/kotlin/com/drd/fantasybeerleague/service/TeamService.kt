package com.drd.fantasybeerleague.service

import com.drd.fantasybeerleague.model.Team
import com.drd.fantasybeerleague.repository.TeamRepository
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TeamService(private val repository: TeamRepository) {

    fun getAllTeams(): MutableList<Team> = repository.findAll()

    fun getTeamByTeamId(teamId: Long) = repository.findById(teamId)

    fun getTeamWithOptionalPlayers(teamId: Long, include: String?): Team {
        val team = repository.findById(teamId).orElseThrow { throw Exception("No team found") }
        if (include == "players") {
            team.players.size // This forces the lazy loaded players to be fetched.
        }
        return team
    }

    fun create(team: Team): Team = repository.save(team)

    fun remove(teamId: Long) {
        if (repository.existsById(teamId)) repository.deleteById(teamId)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, team: Team): Team {
        return if (repository.existsById(id)) {
            repository.save(team)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}