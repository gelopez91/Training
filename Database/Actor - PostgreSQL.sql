
CREATE TABLE actor
(
  actor_id serial NOT NULL,
  firstName character varying(50) NOT NULL,
  lastName character varying(50),
  movie_id integer NOT NULL,
  CONSTRAINT actor_pkey PRIMARY KEY (actor_id),
  CONSTRAINT FK_movie FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);