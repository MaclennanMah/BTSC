package com.maclennanmah.BTSC.sportservice.domain.shared;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
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
