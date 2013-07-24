
CREATE TABLE movie
(
	movie_id serial primary key,
        name VARCHAR(40) not null,
        description VARCHAR(100),
        direction VARCHAR(40),
        year VARCHAR(40) not null,
        language VARCHAR(40) not null,
        duration VARCHAR(40) not null
);