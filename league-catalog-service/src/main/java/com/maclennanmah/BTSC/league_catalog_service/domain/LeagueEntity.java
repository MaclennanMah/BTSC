package com.maclennanmah.BTSC.league_catalog_service.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LEAGUES")
@Getter
@Setter
public class LeagueEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "league_id_generator")
  @SequenceGenerator(name = "league_id_generator", sequenceName = "league_id_generator")
  protected Long id;

  @NotBlank
  @Column(nullable = false)
  protected String name;

  protected String description;

  @NotNull
  @Enumerated(EnumType.STRING)
  protected LeagueGender gender;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, name = "SKILL_LEVEL")
  protected SkillLevel skillLevel;

  @NotNull
  @Enumerated(EnumType.STRING)
  protected Season season;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false, name = "START_DATE")
  protected Date startDate;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false, name = "END_DATE")
  protected Date endDate;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false, name = "REGISTRATION_DEADLINE")
  protected Date registrationDeadline;

  @Column(nullable = false, name = "SEASON_LENGTH")
  @Size(min = 1, max = 100)
  protected int seasonLength;

  @NotNull
  @Column(nullable = false, name = "TEAM_SIZE")
  @Size(min = 1, max = 30)
  protected int teamSize;

  @NotNull
  @Column(nullable = false)
  protected boolean officiated;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, name = "DAY_OF_WEEK")
  protected DayOfWeek dayOfWeek;

  @Temporal(TemporalType.TIME)
  @Column(nullable = false, name = "START_TIME")
  protected ZonedDateTime startTime;

  @Temporal(TemporalType.TIME)
  @Column(nullable = false, name = "END_TIME")
  protected ZonedDateTime endTime;

  @NotNull
  @Column(nullable = false)
  @DecimalMin(value = "0.0")
  protected BigDecimal price;

  @OneToOne(
      mappedBy = "league",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  protected FieldEntity field;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "league_player",
      joinColumns = @JoinColumn(name = "league_id"),
      inverseJoinColumns = @JoinColumn(name = "player_id")
  )
  protected Set<PlayerEntity> players = new HashSet<>();

  @OneToMany(mappedBy = "league",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  protected List<TeamEntity> teams = new ArrayList<>();

  @OneToMany(mappedBy = "division",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  protected List<DivisionEntity> divisions = new ArrayList<>();

  protected AddressEmbeddable address;

  public void addDivision(DivisionEntity division) {
    divisions.add(division);
    division.setLeague(this);
  }

  public void removeDivision(DivisionEntity division) {
    divisions.remove(division);
    division.setLeague(null);
  }

  public void addTeam(TeamEntity team) {
    teams.add(team);
    team.setLeague(this);
  }

  public void removeTeam(TeamEntity team) {
    teams.remove(team);
    team.setLeague(null);
  }

  public void addPlayer(PlayerEntity player) {
    players.add(player);
    player.getLeagues().add(this);
  }

  public void removePlayer(PlayerEntity player) {
    players.remove(player);
    player.getLeagues().remove(this);
  }

  public void setField(FieldEntity field) {
    if (field == null) {
      if (this.field != null) {
        this.field.setLeague(null);
      }
    } else {
      field.setLeague(this);
    }
    this.field = field;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LeagueEntity)) {
      return false;
    }
    return id != null && id.equals(((LeagueEntity) o).getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
