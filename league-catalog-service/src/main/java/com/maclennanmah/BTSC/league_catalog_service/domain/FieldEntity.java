package com.maclennanmah.BTSC.league_catalog_service.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "FIELDS")
@Getter
@Setter
public class FieldEntity implements Serializable {

  @Id
  protected Long id;

  @NotBlank
  @Column(nullable = false)
  @NaturalId
  protected String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  protected Surface surface;

  @NotBlank
  @Column(nullable = false)
  protected String size;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "id")
  protected LeagueEntity league;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FieldEntity)) {
      return false;
    }
    return name != null && name.equals(((FieldEntity) o).getName());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
