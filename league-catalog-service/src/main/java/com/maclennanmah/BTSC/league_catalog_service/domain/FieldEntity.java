package com.maclennanmah.BTSC.league_catalog_service.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FIELDS")
@Getter
@Setter
public class FieldEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_sequence_generator")
  @SequenceGenerator(name = "field_sequence_generator", sequenceName = "field_sequence_generator")
  protected Long id;

  @NotBlank
  @Column(nullable = false)
  protected String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  protected Surface surface;

  @NotBlank
  @Column(nullable = false)
  protected String size;

  @OneToOne(fetch = FetchType.LAZY)
  protected LeagueEntity league;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FieldEntity)) {
      return false;
    }
    return id != null && id.equals(((FieldEntity) o).getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
