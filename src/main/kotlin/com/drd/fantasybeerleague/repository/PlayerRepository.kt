package com.drd.fantasybeerleague.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.drd.fantasybeerleague.model.Player

interface PlayerRepository : JpaRepository<Player, Long>