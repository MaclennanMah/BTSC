package com.maclennanmah.BTSC.league_catalog_service.domain;


import java.util.Optional;
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

  public Optional<League> getLeagueByID(Long leagueID) {
    return leagueRepository.findById(leagueID).map(LeagueMapper::toLeagueDTO);
  }
}
