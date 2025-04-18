package com.maclennanmah.BTSC.league_catalog_service.web;

import com.maclennanmah.BTSC.league_catalog_service.domain.League;
import com.maclennanmah.BTSC.league_catalog_service.domain.LeagueService;
import com.maclennanmah.BTSC.league_catalog_service.domain.PagedResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

  @GetMapping("/{leagueID}")
  League getLeague(@PathVariable Long leagueID) {
    log.info("Fetching league with id: {}", leagueID);
    return leagueService.getLeagueByID(leagueID);

  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  League createLeague(@RequestBody League league) {
    log.info("Creating league: {}", league);
    return leagueService.createLeague(league);
  }

  @PutMapping("/{leagueID}")
  League updateLeague(@PathVariable Long leagueID, @RequestBody League league) {
    return leagueService.updateLeague(leagueID, league);
  }

  @DeleteMapping("/{leagueID}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteLeague(@PathVariable Long leagueID) {
    log.info("Deleting league with id: {}", leagueID);
    leagueService.deleteLeague(leagueID);
  }
}
