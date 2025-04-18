package com.maclennanmah.BTSC.league_catalog_service.domain;


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

  private final LeagueRepository leagueRepository;

  /**
   * Retrieves a paginated list of leagues.
   *
   * @param pageable The pagination information.
   * @return A paginated response containing the leagues.
   */
  public PagedResponse<League> getLeagues(@NotNull Pageable pageable) {
    Page<LeagueEntity> leaguesPage = leagueRepository.findAll(pageable);
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
  public League getLeagueByID(Long leagueID) {
    return leagueRepository.findById(leagueID).map(LeagueMapper::toLeagueDTO)
        .orElseThrow(() -> LeagueNotFoundException.forId(leagueID));
  }

  /**
   * Creates a new league.
   *
   * @param league The league object to be created.
   * @return The created league object.
   */
  @Transactional
  public League createLeague(@NotNull League league) {
    LeagueEntity leagueEntity = LeagueMapper.toLeagueEntity(league);
    LeagueEntity savedLeagueEntity = leagueRepository.save(leagueEntity);
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
  public League updateLeague(Long leagueID, @NotNull League league) {
    return leagueRepository.findById(leagueID)
        .map(leagueEntity -> {
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
              leagueEntity.getAddress().setStreet(league.street());
              leagueEntity.getAddress().setCity(league.city());
              leagueEntity.getAddress().setProvince(league.province());
              leagueEntity.getAddress().setZipCode(league.zipCode());
              leagueEntity.getAddress().setCountry(league.country());
              return leagueRepository.save(leagueEntity);
            }
        ).map(LeagueMapper::toLeagueDTO)

        .orElseGet(() -> {
          LeagueEntity leagueEntity = leagueRepository.save(LeagueMapper.toLeagueEntity(league));
          return LeagueMapper.toLeagueDTO(leagueEntity);
        });
  }

  @Transactional
  public void deleteLeague(Long leagueID) {
    leagueRepository.findById(leagueID)
        .ifPresentOrElse(
            leagueRepository::delete,
            () -> {
              throw LeagueNotFoundException.forId(leagueID);
            }
        );
  }
}
