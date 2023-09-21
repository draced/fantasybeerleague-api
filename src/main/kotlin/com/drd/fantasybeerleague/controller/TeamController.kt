package com.drd.fantasybeerleague.controller

import com.drd.fantasybeerleague.model.Team
import com.drd.fantasybeerleague.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/teams")
class TeamController(private val service: TeamService) {

    @GetMapping
    fun getAllTeams() = service.getAllTeams()

    @GetMapping("/{teamId}")
    fun getTeam(@PathVariable teamId: Long,
                @RequestParam(required = false) include: String?): Team = service.getTeamWithOptionalPlayers(teamId, include)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveTeam(@RequestBody team: Team): Team = service.create(team)

    @DeleteMapping("/{teamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTeam(@PathVariable teamId: Long) = service.remove(teamId)

    @PutMapping("/{teamId}")
    fun updateTeam(
        @PathVariable teamId: Long, @RequestBody team: Team
    ) = service.update(teamId, team)
}