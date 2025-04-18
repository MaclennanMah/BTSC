-- Insert test data for players
INSERT INTO players (id, birth_date, email, first_name, last_name, gender, phone_number)
VALUES (11, '1990-01-01 00:00:00', 'player1@example.com', 'John', 'Doe', 'MEN', '123-456-7890'),
       (22, '1992-02-02 00:00:00', 'player2@example.com', 'Jane', 'Smith', 'WOMEN',
        '987-654-3210'),
       (33, '1985-03-03 00:00:00', 'player3@example.com', 'Alice', 'Johnson', 'WOMEN',
        '555-123-4567'),
       (44, '1995-04-04 00:00:00', 'player4@example.com', 'Bob', 'Brown', 'MEN', '555-987-6543'),
       (55, '2000-05-05 00:00:00', 'player5@example.com', 'Charlie', 'Davis', 'CO_ED',
        '555-456-7890');

-- Insert test data for leagues
INSERT INTO leagues (id, name, description, gender, skill_level, season, start_date, end_date,
                     registration_deadline, season_length, team_size, officiated, day_of_week,
                     start_time, end_time, price, street, city, province, country, zip_code)
VALUES (11, 'Summer League', 'A fun summer league', 'CO_ED', 'INTERMEDIATE', 'SUMMER', '2023-06-01',
        '2023-08-31', '2023-05-15', 12, 11, true, 'SATURDAY', '2023-06-01 10:00:00+00',
        '2023-06-01 12:00:00+00', 100.00, '123 Main St', 'Toronto', 'ON', 'Canada', 'M1A1A1'),
       (22, 'Winter League', 'A competitive winter league', 'MEN', 'ADVANCED', 'WINTER',
        '2023-12-01',
        '2024-02-28', '2023-11-15', 10, 8, true, 'SUNDAY', '2023-12-01 14:00:00+00',
        '2023-12-01 16:00:00+00', 150.00, '456 Elm St', 'Vancouver', 'BC', 'Canada', 'V5K0A1')
        ,
       (33, 'Fall League', 'A beginner-friendly fall league', 'WOMEN', 'RECREATIONAL', 'FALL',
        '2023-09-01',
        '2023-11-30', '2023-08-15', 12, 6, false, 'WEDNESDAY', '2023-09-01 18:00:00+00',
        '2023-09-01 20:00:00+00', 80.00, '789 Oak St', 'Montreal', 'QC', 'Canada', 'H1A1A1');

-- Insert test data for divisions
INSERT INTO divisions (id, league_id, name, status)
VALUES (11, 11, 'Division A', 'OPEN'),
       (22, 11, 'Division B', 'CLOSED'),
       (33, 22, 'Division C', 'OPEN'),
       (44, 33, 'Division D', 'CLOSED');

-- Insert test data for teams
INSERT INTO teams (id, league_id, division_id, name, color, roster_status)
VALUES (11, 11, 11, 'Team Alpha', 'Red', 'OPEN'),
       (22, 11, 22, 'Team Beta', 'Blue', 'CLOSED'),
       (33, 22, 33, 'Team Gamma', 'Green', 'OPEN'),
       (44, 33, 44, 'Team Delta', 'Yellow', 'CLOSED');

-- Insert test data for fields
INSERT INTO fields (id, name, size, surface)
VALUES (11, 'Field 1', '100x50', 'TURF'),
       (22, 'Field 2', '120x60', 'SOFT_GROUND'),
       (33, 'Field 3', '90x45', 'TURF');


-- Insert test data for league_player
INSERT INTO league_player (league_id, player_id)
VALUES (11, 11),
       (11, 22),
       (22, 33),
       (33, 44);

-- Insert test data for division_player
INSERT INTO division_player (division_id, player_id)
VALUES (11, 11),
       (22, 22),
       (33, 33),
       (44, 44);

-- Insert test data for team_player
INSERT INTO team_player (team_id, player_id)
VALUES (11, 11),
       (22, 22),
       (33, 33),
       (44, 44);