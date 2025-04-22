package com.maclennanmah.BTSC.sportservice.domain.player;


import com.maclennanmah.BTSC.sportservice.domain.division.DivisionEntity;
import com.maclennanmah.BTSC.sportservice.domain.league.LeagueEntity;
import com.maclennanmah.BTSC.sportservice.domain.shared.PagedResponse;
import com.maclennanmah.BTSC.sportservice.domain.shared.exceptions.PlayerNotFoundException;
import com.maclennanmah.BTSC.sportservice.domain.team.TeamEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//TODO: findAll findById bad practice?

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepository repository;

  public PagedResponse<Player> getPlayers(Pageable pageable) {
    Page<PlayerEntity> playersPage = repository.findAll(pageable);
    return new PagedResponse<>(
        playersPage.getContent().stream().map(PlayerMapper::toDTO).toList(),
        playersPage.getTotalElements(),
        playersPage.getNumber() + 1,
        playersPage.getTotalPages(),
        playersPage.isFirst(),
        playersPage.isLast(),
        playersPage.hasNext(),
        playersPage.hasPrevious()
    );
  }

  public Player getPlayer(Long id) {
    return repository.findById(id).map(PlayerMapper::toDTO)
        .orElseThrow(() -> PlayerNotFoundException.forId(id));
  }

  @Transactional
  public Player createPlayer(@NotNull @Valid Player player) {
    PlayerEntity savedPlayer = repository.save(PlayerMapper.toPlayerEntity(player));
    return PlayerMapper.toDTO(savedPlayer);
  }

  @Transactional
  public Player updatePlayer(Player player, Long playerID) {
    PlayerEntity playerEntity = repository.findById(playerID)
        .orElseThrow(() -> PlayerNotFoundException.forId(playerID));

    updatePlayerEntity(playerEntity, player);
    PlayerEntity updatedPlayer = repository.save(playerEntity);

    return PlayerMapper.toDTO(updatedPlayer);
  }

  @Transactional
  public void deletePlayer(Long playerID) {
    PlayerEntity player = repository.findById(playerID)
        .orElseThrow(() -> PlayerNotFoundException.forId(playerID));
    for (TeamEntity teamEntity : player.getTeams()) {
      teamEntity.removePlayer(player);
    }
    for (LeagueEntity leagueEntity : player.getLeagues()) {
      leagueEntity.removePlayer(player);
    }
    for (DivisionEntity divisionEntity : player.getDivisions()) {
      divisionEntity.removePlayer(player);
    }
    repository.delete(player);
  }

  private void updatePlayerEntity(PlayerEntity playerEntity, Player player) {
    playerEntity.setFirstName(player.firstName());
    playerEntity.setLastName(player.lastName());
    playerEntity.setEmail(player.email());
    playerEntity.setBirthDate(player.birthDate());
    playerEntity.setPhoneNumber(player.phoneNumber());
    playerEntity.setGender(player.gender());
  }
}
