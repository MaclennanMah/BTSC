package com.maclennanmah.BTSC.sportservice.domain.league;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LeagueRepository extends JpaRepository<LeagueEntity, Long> {

}
