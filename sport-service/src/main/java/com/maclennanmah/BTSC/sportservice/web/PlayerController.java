package com.maclennanmah.BTSC.sportservice.web;


import com.maclennanmah.BTSC.sportservice.domain.player.Player;
import com.maclennanmah.BTSC.sportservice.domain.player.PlayerService;
import com.maclennanmah.BTSC.sportservice.domain.shared.PagedResponse;
import jakarta.validation.Valid;
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
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService service;

  @GetMapping
  public PagedResponse<Player> getPlayers(@PageableDefault Pageable pageable) {
    log.info("Fetching players for page {}", pageable.getPageNumber());
    return service.getPlayers(pageable);
  }

  @GetMapping("/{playerID}")
  public Player getPlayer(@PathVariable Long playerID) {
    log.info("Fetching player with id {}", playerID);
    return service.getPlayer(playerID);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Player createPlayer(@RequestBody @Valid Player player) {
    log.info("Creating player {}", player);
    return service.createPlayer(player);
  }

  @PutMapping("/{playerID}")
  public Player updatePlayer(@PathVariable Long playerID, @RequestBody @Valid Player player) {
    log.info("Updating player {}", player);
    return service.updatePlayer(player, playerID);
  }

  @DeleteMapping("/{playerID}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletePlayer(@PathVariable Long playerID) {
    log.info("Deleting player {}", playerID);
    service.deletePlayer(playerID);
  }
}
