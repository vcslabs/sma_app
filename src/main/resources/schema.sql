DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Matches;
DROP TABLE IF EXISTS Characters;

CREATE TABLE IF NOT EXISTS Users(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(250) NOT NULL,
    rate INT NOT NULL,
    matching_status int NOT NULL,
    main_character_id int NOT NULL,
    sub1_character_id int,
    sub2_character_id int,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Matches(
    id INT AUTO_INCREMENT NOT NULL,
    user_id int NOT NULL,
    user_rate int NOT NULL,
    opponent_id int NOT NULL,
    opponent_rate int NOT NULL,
    status_code int NOT NULL,
    used_character1_id int NOT NULL,
    used_character2_id int,
    used_character3_id int,
    opponent_character1_id int NOT NULL,
    opponent_character2_id int,
    opponent_character3_id int,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Characters(
    id INT AUTO_INCREMENT NOT NULL,
    character_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO Users (name, password, matching_status, rate, main_character_id, sub1_character_id, sub2_character_id)
VALUES ("testUser1", "testPassword", 1, 1500, 1, 2, 3);

INSERT INTO Users (name, password, matching_status, rate, main_character_id, sub1_character_id, sub2_character_id)
VALUES ("testUser2", "testPassword", 0, 1600, 3, 2, 1);

INSERT INTO Users (name, password, matching_status, rate, main_character_id, sub1_character_id, sub2_character_id)
VALUES ("testUser3", "testPassword", 1, 1700, 3, 2, 1);

INSERT INTO Users (name, password, matching_status, rate, main_character_id, sub1_character_id, sub2_character_id)
VALUES ("testUser4", "testPassword", 2, 1800, 2, 2, 1);

INSERT INTO Users (name, password, matching_status, rate, main_character_id, sub1_character_id, sub2_character_id)
VALUES ("testUser5", "testPassword", 1, 1650, 2, 2, 1);

INSERT INTO Users (name, password, matching_status, rate, main_character_id, sub1_character_id, sub2_character_id)
VALUES ("testUser6", "testPassword", 1, 1550, 2, 2, 1);

INSERT INTO Users (name, password, matching_status, rate, main_character_id, sub1_character_id, sub2_character_id)
VALUES ("testUser7", "testPassword", 1, 1950, 4, 2, 1);

INSERT INTO Characters (character_name)
VALUES ("マリオ");

INSERT INTO Characters (character_name)
VALUES ("ヨッシー");

INSERT INTO Characters (character_name)
VALUES ("ジョーカー");

INSERT INTO Characters (character_name)
VALUES ("ピカチュウ");

INSERT INTO Matches (user_id, user_rate, opponent_id, opponent_rate, status_code, used_character1_id, used_character2_id, used_character3_id, opponent_character1_id, opponent_character2_id, opponent_character3_id)
VALUES (1, 1500, 2, 1600, 1, 1, 1, 1, 3, 1, 1);

INSERT INTO Matches (user_id, user_rate, opponent_id, opponent_rate, status_code, used_character1_id, used_character2_id, used_character3_id, opponent_character1_id, opponent_character2_id, opponent_character3_id)
VALUES (1, 1515, 3, 1560, 1, 2, 1, 1, 1, 1, 1);

INSERT INTO Matches (user_id, user_rate, opponent_id, opponent_rate, status_code, used_character1_id, used_character2_id, used_character3_id, opponent_character1_id, opponent_character2_id, opponent_character3_id)
VALUES (2, 1600, 1, 1500, 2, 3, 1, 1, 1, 1, 1);

INSERT INTO Matches (user_id, user_rate, opponent_id, opponent_rate, status_code, used_character1_id, used_character2_id, used_character3_id, opponent_character1_id, opponent_character2_id, opponent_character3_id)
VALUES (2, 1650, 4, 1700, 2, 2, 1, 1, 4, 1, 1);

INSERT INTO Matches (user_id, user_rate, opponent_id, opponent_rate, status_code, used_character1_id, used_character2_id, used_character3_id, opponent_character1_id, opponent_character2_id, opponent_character3_id)
VALUES (3, 1560, 1, 1515, 2, 1, 1, 1, 2, 1, 1);

INSERT INTO Matches (user_id, user_rate, opponent_id, opponent_rate, status_code, used_character1_id, used_character2_id, used_character3_id, opponent_character1_id, opponent_character2_id, opponent_character3_id)
VALUES (4, 1700, 2, 1650, 1, 4, 1, 1, 2, 1, 1);
