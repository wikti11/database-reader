CREATE TABLE Track(
id  INT PRIMARY KEY,
track_name VARCHAR(50) NOT NULL UNIQUE,
track_length INT NOT NULL,
amount_of_corners INT NOT NULL,
year_built INT,
country VARCHAR(50),
date_time DATE
);

CREATE TABLE Team(
id INT PRIMARY KEY,
team_name VARCHAR(50) NOT NULL UNIQUE,
engine_supplier VARCHAR(50),
localization VARCHAR(50),
year_found INT,
date_time DATE
);

CREATE TABLE Team_principal(
id INT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL UNIQUE,
team VARCHAR(50) REFERENCES Team(team_name),
age INT,
nationality VARCHAR(50),
date_time DATE
);

CREATE TABLE Driver(
id INT PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50),
number INT NOT NULL UNIQUE,
team VARCHAR(50) REFERENCES Team(team_name),
age INT,
nationality VARCHAR(50),
date_time DATE
);

CREATE TABLE Result(
id INT PRIMARY KEY,
result_date VARCHAR(10),
track_name VARCHAR(50) REFERENCES Track(track_name),
number INT REFERENCES Driver(number),
result_position INT,
date_time DATE
);