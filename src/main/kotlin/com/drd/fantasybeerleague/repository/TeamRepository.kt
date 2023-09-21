package com.drd.fantasybeerleague.repository

import com.drd.fantasybeerleague.model.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, Long>