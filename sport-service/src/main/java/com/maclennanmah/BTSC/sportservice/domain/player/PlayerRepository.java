package com.maclennanmah.BTSC.sportservice.domain.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
