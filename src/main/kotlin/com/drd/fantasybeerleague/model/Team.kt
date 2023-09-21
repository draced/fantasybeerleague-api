package com.drd.fantasybeerleague.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "team")
data class Team(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    val teamId: Long = 0,

    @Column(name = "team_name", nullable = false)
    val teamName: String,

    @Column(name = "league_id")
    val leagueId: Int? = null,

    @Column(name = "created_date")
    val createdDate: LocalDate? = null,

    @Column(name = "city_name")
    val cityName: String? = null,

    @Column(name = "owner_id")
    val ownerId: Int,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "team_player",
        joinColumns = [JoinColumn(name = "team_id")],
        inverseJoinColumns = [JoinColumn(name = "player_id")]
    )
    val players: MutableList<Player> = mutableListOf()
)