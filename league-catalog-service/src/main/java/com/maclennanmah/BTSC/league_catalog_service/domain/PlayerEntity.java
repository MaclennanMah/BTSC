package com.maclennanmah.BTSC.league_catalog_service.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "PLAYERS")
@Getter
@Setter
public class PlayerEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence_generator")
  @SequenceGenerator(name = "player_sequence_generator", sequenceName = "player_sequence_generator")
  protected Long id;

  @NotBlank
  @Column(nullable = false, name = "FIRST_NAME")
  protected String firstName;

  @NotBlank
  @Column(nullable = false, name = "LAST_NAME")
  protected String lastName;

  @Column(nullable = false, unique = true)
  @Email(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$")
  @NaturalId
  protected String email;

  @NotBlank
  @Column(nullable = false, name = "PHONE_NUMBER")
  protected String phoneNumber;

  @Past
  @Column(nullable = false, name = "BIRTH_DATE")
  protected Date birthDate;

  @NotBlank
  @Column(nullable = false)
  protected String gender;

  @ManyToMany(mappedBy = "players")
  protected Set<LeagueEntity> leagues = new HashSet<>();

  @ManyToMany(mappedBy = "players")
  protected Set<TeamEntity> teams = new HashSet<>();

  @ManyToMany(mappedBy = "players")
  protected Set<DivisionEntity> divisions = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerEntity)) {
      return false;
    }
    return email != null && email.equals(((PlayerEntity) o).getEmail());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
