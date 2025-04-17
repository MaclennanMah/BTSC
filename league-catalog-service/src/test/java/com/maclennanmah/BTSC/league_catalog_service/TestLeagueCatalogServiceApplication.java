package com.maclennanmah.BTSC.league_catalog_service;

import org.springframework.boot.SpringApplication;

public class TestLeagueCatalogServiceApplication {

  public static void main(String[] args) {
    SpringApplication.from(LeagueCatalogServiceApplication::main).with(ContainersConfig.class)
        .run(args);
  }

}
