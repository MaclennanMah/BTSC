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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "DIVISIONS")
@Getter
@Setter
public class DivisionEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_sequence_generator")
  @SequenceGenerator(name = "division_sequence_generator", sequenceName = "division_sequence_generator")
  protected Long id;

  @NotBlank
  @Column(nullable = false,
      unique = true,
      length = 128
  )
  @NaturalId
  protected String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  protected Status status;

  @OneToMany(mappedBy = "division",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  protected List<TeamEntity> teams = new ArrayList<>();

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(name = "league_id")
  protected LeagueEntity league;

  @ManyToMany(
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      }
  )
  @JoinTable(name = "division_player",
      joinColumns = @JoinColumn(name = "division_id"),
      inverseJoinColumns = @JoinColumn(name = "player_id")
  )
  protected Set<PlayerEntity> players = new HashSet<>();

  public void addPlayer(PlayerEntity player) {
    players.add(player);
    player.getDivisions().add(this);
  }

  public void removePlayer(PlayerEntity player) {
    players.remove(player);
    player.getDivisions().remove(this);
  }

  public void addTeam(TeamEntity team) {
    teams.add(team);
    team.setDivision(this);
  }

  public void removeTeam(TeamEntity team) {
    teams.remove(team);
    team.setDivision(null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DivisionEntity)) {
      return false;
    }
    return name != null && name.equals(((DivisionEntity) o).getName());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
