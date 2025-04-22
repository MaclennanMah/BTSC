-- Create sequence for divisions
CREATE SEQUENCE division_sequence_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Create sequence for leagues
CREATE SEQUENCE league_sequence_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Create sequence for players
CREATE SEQUENCE player_sequence_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Create sequence for teams
CREATE SEQUENCE team_sequence_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--TODO: Add more constraints

-- Create table for players
CREATE TABLE players
(
    id           BIGINT       NOT NULL PRIMARY KEY,
    birth_date   TIMESTAMP(6) NOT NULL,
    email        VARCHAR(255) NOT NULL UNIQUE,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    gender       VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL
);

-- Create table for leagues
CREATE TABLE leagues
(
    id                    BIGINT                      NOT NULL PRIMARY KEY,
    name                  VARCHAR(255)                NOT NULL UNIQUE,
    description           VARCHAR(255),
    gender                VARCHAR(255) CHECK (gender IN ('MEN', 'WOMEN', 'CO_ED')),
    skill_level           VARCHAR(255)                NOT NULL CHECK (skill_level IN ('RECREATIONAL', 'INTERMEDIATE', 'ADVANCED')),
    season                VARCHAR(255) CHECK (season IN ('WINTER', 'SUMMER', 'FALL', 'SPRING')),
    start_date            DATE                        NOT NULL,
    end_date              DATE                        NOT NULL,
    registration_deadline DATE                        NOT NULL,
    season_length         INTEGER                     NOT NULL,
    team_size             INTEGER                     NOT NULL,
    officiated            BOOLEAN                     NOT NULL,
    day_of_week           VARCHAR(255)                NOT NULL CHECK (day_of_week IN
                                                                      ('MONDAY', 'TUESDAY',
                                                                       'WEDNESDAY', 'THURSDAY',
                                                                       'FRIDAY', 'SATURDAY',
                                                                       'SUNDAY')),
    start_time            TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    end_time              TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    price                 NUMERIC(38, 2)              NOT NULL,
    street                VARCHAR(255)                NOT NULL,
    city                  VARCHAR(255)                NOT NULL,
    province              VARCHAR(255)                NOT NULL,
    country               VARCHAR(255)                NOT NULL,
    zip_code              VARCHAR(255)                NOT NULL
);

-- Create table for divisions
CREATE TABLE divisions
(
    id        BIGINT       NOT NULL PRIMARY KEY,
    league_id BIGINT REFERENCES leagues (id),
    name      VARCHAR(128) NOT NULL UNIQUE,
    status    VARCHAR(255) CHECK (status IN ('OPEN', 'CLOSED'))
);

-- Create table for teams
CREATE TABLE teams
(
    id            BIGINT       NOT NULL PRIMARY KEY,
    league_id     BIGINT REFERENCES leagues (id),
    division_id   BIGINT REFERENCES divisions (id),
    name          VARCHAR(255) NOT NULL UNIQUE,
    color         VARCHAR(255) NOT NULL,
    roster_status VARCHAR(255) NOT NULL CHECK (roster_status IN ('OPEN', 'CLOSED'))
);

-- Create table for fields
CREATE TABLE fields
(
    id      BIGINT       NOT NULL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL UNIQUE,
    size    VARCHAR(255) NOT NULL,
    surface VARCHAR(255) CHECK (surface IN
                                ('HARD_GROUND', 'FIRM_GROUND', 'SOFT_GROUND', 'ARTIFICIAL_GROUND',
                                 'TURF', 'INDOOR'))
);

-- Create table for league_player
CREATE TABLE league_player
(
    league_id BIGINT NOT NULL REFERENCES leagues (id),
    player_id BIGINT NOT NULL REFERENCES players (id),
    PRIMARY KEY (league_id, player_id)
);

-- Create table for division_player
CREATE TABLE division_player
(
    division_id BIGINT NOT NULL REFERENCES divisions (id),
    player_id   BIGINT NOT NULL REFERENCES players (id),
    PRIMARY KEY (division_id, player_id)
);

-- Create table for team_player
CREATE TABLE team_player
(
    team_id   BIGINT NOT NULL REFERENCES teams (id),
    player_id BIGINT NOT NULL REFERENCES players (id),
    PRIMARY KEY (team_id, player_id)
);