package com.maclennanmah.BTSC.league_catalog_service.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class AddressEmbeddable {

  @NotBlank
  @Column(nullable = false)
  protected String street;

  @NotBlank
  @Column(nullable = false)
  protected String city;

  @NotBlank
  @Column(nullable = false)
  protected String province;

  @NotBlank
  @Column(nullable = false)
  protected String zipCode;

  @NotBlank
  @Column(nullable = false)
  protected String country;

}
