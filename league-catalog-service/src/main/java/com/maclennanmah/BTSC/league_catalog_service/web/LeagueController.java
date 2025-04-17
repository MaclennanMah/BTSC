package com.maclennanmah.BTSC.league_catalog_service.web;

import com.maclennanmah.BTSC.league_catalog_service.domain.League;
import com.maclennanmah.BTSC.league_catalog_service.domain.LeagueEntity;
import com.maclennanmah.BTSC.league_catalog_service.domain.LeagueNotFoundException;
import com.maclennanmah.BTSC.league_catalog_service.domain.LeagueService;
import com.maclennanmah.BTSC.league_catalog_service.domain.PagedResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/leagues")
@RequiredArgsConstructor
public class LeagueController {

  private final LeagueService leagueService;

  @GetMapping("")
  PagedResponse<League> getLeagues(@PageableDefault Pageable pageable) {
    log.info("Fetching leagues for page: {}", pageable.getPageNumber());
    return leagueService.getLeagues(pageable);
  }

  @GetMapping("/{code}")
  ResponseEntity<League> getLeague(@PathVariable Long code) {
    log.info("Fetching league with id: {}", code);
    return leagueService.getLeagueByID(code)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> LeagueNotFoundException.forId(code));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  League createLeague(@RequestBody League league) {
    log.info("Creating league: {}", league);
    return null;
  }

  @PutMapping("/{id}")
  LeagueEntity updateLeague(@PathVariable String leagueID) {
    return new LeagueEntity();
  }

  @DeleteMapping("/{id}")
  void deleteLeague(@PathVariable(name = "leagueID") @NotBlank String leagueID) {
    return;
  }
}
