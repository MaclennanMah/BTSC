package com.maclennanmah.BTSC.sportservice.domain.league;


import com.maclennanmah.BTSC.sportservice.domain.shared.AddressEmbeddable;
import com.maclennanmah.BTSC.sportservice.domain.shared.PagedResponse;
import com.maclennanmah.BTSC.sportservice.domain.shared.exceptions.LeagueNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LeagueService {

  private final LeagueRepository repository;

  /**
   * Retrieves a paginated list of leagues.
   *
   * @param pageable The pagination information.
   * @return A paginated response containing the leagues.
   */
  public PagedResponse<League> getLeagues(@NotNull Pageable pageable) {
    Page<LeagueEntity> leaguesPage = repository.findAll(pageable);
    return new PagedResponse<>(
        leaguesPage.getContent().stream().map(LeagueMapper::toLeagueDTO).toList(),
        leaguesPage.getTotalElements(),
        leaguesPage.getNumber() + 1,
        leaguesPage.getTotalPages(),
        leaguesPage.isFirst(),
        leaguesPage.isLast(),
        leaguesPage.hasNext(),
        leaguesPage.hasPrevious()
    );
  }

  /**
   * Retrieves a league by its ID.
   *
   * @param leagueID The ID of the league to be retrieved.
   * @return The league object with the specified ID.
   * @throws LeagueNotFoundException if the league with the given ID does not exist.
   */
  public League getLeagueByID(@NotNull Long leagueID) {
    return repository.findById(leagueID).map(LeagueMapper::toLeagueDTO)
        .orElseThrow(() -> LeagueNotFoundException.forId(leagueID));
  }

  /**
   * Creates a new league.
   *
   * @param league The league object to be created.
   * @return The created league object.
   */
  @Transactional
  public League createLeague(@NotNull @Valid League league) {
    LeagueEntity leagueEntity = LeagueMapper.toLeagueEntity(league);
    LeagueEntity savedLeagueEntity = repository.save(leagueEntity);
    return LeagueMapper.toLeagueDTO(savedLeagueEntity);
  }

  /**
   * Updates an existing league or creates a new one if it doesn't exist.
   *
   * @param leagueID The ID of the league to be updated.
   * @param league   The league object containing the new values.
   * @return The updated or newly created league object.
   */
  @Transactional
  public League updateLeague(@NotNull Long leagueID, @NotNull @Valid League league) {
    LeagueEntity leagueEntity = repository.findById(leagueID)
        .orElseThrow(() -> LeagueNotFoundException.forId(leagueID));

    updateLeagueEntity(leagueEntity, league);
    LeagueEntity updatedLeagueEntity = repository.save(leagueEntity);

    return LeagueMapper.toLeagueDTO(updatedLeagueEntity);
  }

  @Transactional
  public void deleteLeague(@NotNull Long leagueID) {
    repository.findById(leagueID)
        .ifPresentOrElse(
            repository::delete,
            () -> {
              throw LeagueNotFoundException.forId(leagueID);
            }
        );
  }

  private void updateLeagueEntity(@NotNull LeagueEntity leagueEntity,
      @NotNull @Valid League league) {
    leagueEntity.setName(league.name());
    leagueEntity.setDescription(league.description());
    leagueEntity.setGender(league.gender());
    leagueEntity.setSkillLevel(league.skillLevel());
    leagueEntity.setSeason(league.season());
    leagueEntity.setStartDate(league.startDate());
    leagueEntity.setEndDate(league.endDate());
    leagueEntity.setRegistrationDeadline(league.registrationDeadline());
    leagueEntity.setSeasonLength(league.seasonLength());
    leagueEntity.setTeamSize(league.teamSize());
    leagueEntity.setOfficiated(league.officiated());
    leagueEntity.setDayOfWeek(league.dayOfWeek());
    leagueEntity.setStartTime(league.startTime());
    leagueEntity.setEndTime(league.endTime());
    leagueEntity.setPrice(league.price());

    updateAddress(leagueEntity.getAddress(), league);
  }

  private void updateAddress(@NotNull AddressEmbeddable addressEntity,
      @NotNull @Valid League league) {
    addressEntity.setStreet(league.street());
    addressEntity.setCity(league.city());
    addressEntity.setProvince(league.province());
    addressEntity.setZipCode(league.zipCode());
    addressEntity.setCountry(league.country());
  }
}
