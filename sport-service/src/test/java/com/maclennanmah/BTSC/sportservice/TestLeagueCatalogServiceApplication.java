package com.maclennanmah.BTSC.sportservice;

import org.springframework.boot.SpringApplication;

public class TestLeagueCatalogServiceApplication {

  public static void main(String[] args) {
    SpringApplication.from(SportServiceApplication::main).with(ContainersConfig.class)
        .run(args);
  }

}
