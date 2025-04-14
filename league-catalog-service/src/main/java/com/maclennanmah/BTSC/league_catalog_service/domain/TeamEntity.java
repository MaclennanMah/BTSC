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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TEAMS")
@Getter
@Setter
public class TeamEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_sequence_generator")
  @SequenceGenerator(name = "team_sequence_generator", sequenceName = "team_sequence_generator")
  protected Long id;

  @NotBlank
  @Column(nullable = false)
  protected String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, name = "ROSTER_STATUS")
  protected Status rosterStatus;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(name = "league_id")
  protected LeagueEntity league;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(name = "division_id")
  protected DivisionEntity division;

  @NotBlank
  @Column(nullable = false)
  protected String color;

  @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinTable(name = "team_player", joinColumns = @JoinColumn(name = "team_id"),
      inverseJoinColumns = @JoinColumn(name = "player_id")
  )
  protected Set<PlayerEntity> players = new HashSet<>();

  protected void addPlayer(PlayerEntity player) {
    players.add(player);
    player.getTeams().add(this);
  }

  protected void removePlayer(PlayerEntity player) {
    players.remove(player);
    player.getTeams().remove(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TeamEntity)) {
      return false;
    }
    return id != null && id.equals(((TeamEntity) o).getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
