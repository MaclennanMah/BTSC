package com.maclennanmah.BTSC.league_catalog_service.domain;


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

  public PagedResponse<League> getLeagues(Pageable pageable) {
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

  public League getLeagueByID(Long leagueID) {
    return leagueRepository.findById(leagueID).map(LeagueMapper::toLeagueDTO)
        .orElseThrow(() -> LeagueNotFoundException.forId(leagueID));
  }

  @Transactional
  public League createLeague(League league) {
    LeagueEntity leagueEntity = LeagueMapper.toLeagueEntity(league);
    LeagueEntity savedLeagueEntity = leagueRepository.save(leagueEntity);
    return LeagueMapper.toLeagueDTO(savedLeagueEntity);
  }

  @Transactional
  public League updateLeague(Long leagueID, League league) {
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
