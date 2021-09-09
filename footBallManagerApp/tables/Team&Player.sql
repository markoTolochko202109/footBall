CREATE TABLE my_db.teams (
        id int NOT NULL AUTO_INCREMENT,
        name varchar(15),
        city varchar(15),
        country varchar(15),
        PRIMARY KEY (id)
        );

        CREATE TABLE my_db.players (
        id int NOT NULL AUTO_INCREMENT,
        name varchar(15),
        surname varchar(25),
        careerStartDay varchar(25),
        team_id int,
        PRIMARY KEY (id),
        FOREIGN KEY (team_id) REFERENCES my_db.teams(id));