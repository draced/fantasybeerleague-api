package com.drd.fantasybeerleague.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*

@Schema(description = "Model for a player")
@Entity
@Table(name = "player")
data class Player(
    @Id
    @field:Schema(
            description = "Player ID from HNA",
            example = "1234",
            type = "int",
            minimum = "0",
            maximum = "99999"
    )
    @Column(name = "player_id")
    val playerId: Long,
    @Column(name = "real_team_id")
    val realTeamId: Int,
    @Column(name = "roster_num")
    val rosterNum: Int,
    @Column(name = "player_name")
    val playerName: String,
    @Column(name = "player_num")
    val playerNum: Int,
    @Column(name = "position")
    val position: String,
    @Column(name = "games_played_num")
    val gamesPlayedNum: Int,
    @Column(name = "num_goals")
    val numGoals: Int,
    @Column(name = "num_assists")
    val numAssists: Int,
    @Column(name = "num_points")
    val numPoints: Int,
    @Column(name = "num_pim")
    val numPim: Int
//    ,
//    @ManyToMany(mappedBy = "players")
//    val teams: MutableList<Team> = mutableListOf()
)