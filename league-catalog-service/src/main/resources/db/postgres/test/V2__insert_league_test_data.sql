-- Insert test data for players
INSERT INTO players (id, birth_date, email, first_name, last_name, gender, phone_number)
VALUES (1, '1990-01-01 00:00:00', 'player1@example.com', 'John', 'Doe', 'MEN', '123-456-7890'),
       (2, '1992-02-02 00:00:00', 'player2@example.com', 'Jane', 'Smith', 'WOMEN', '987-654-3210');

-- Insert test data for leagues
INSERT INTO leagues (id, name, description, gender, skill_level, season, start_date, end_date,
                     registration_deadline, season_length, team_size, officiated, day_of_week,
                     start_time, end_time, price, street, city, province, country, zip_code)
VALUES (1, 'Summer League', 'A fun summer league', 'CO_ED', 'INTERMEDIATE', 'SUMMER', '2023-06-01',
        '2023-08-31', '2023-05-15', 12, 11, true, 'SATURDAY', '2023-06-01 10:00:00+00',
        '2023-06-01 12:00:00+00', 100.00, '123 Main St', 'Toronto', 'ON', 'Canada', 'M1A1A1');

-- Insert test data for divisions
INSERT INTO divisions (id, league_id, name, status)
VALUES (1, 1, 'Division A', 'OPEN'),
       (2, 1, 'Division B', 'CLOSED');

-- Insert test data for teams
INSERT INTO teams (id, league_id, division_id, name, color, roster_status)
VALUES (1, 1, 1, 'Team Alpha', 'Red', 'OPEN'),
       (2, 1, 2, 'Team Beta', 'Blue', 'CLOSED');

-- Insert test data for fields
INSERT INTO fields (id, name, size, surface)
VALUES (1, 'Field 1', '100x50', 'TURF');


-- Insert test data for league_player
INSERT INTO league_player (league_id, player_id)
VALUES (1, 1),
       (1, 2);

-- Insert test data for division_player
INSERT INTO division_player (division_id, player_id)
VALUES (1, 1),
       (2, 2);

-- Insert test data for team_player
INSERT INTO team_player (team_id, player_id)
VALUES (1, 1),
       (2, 2);