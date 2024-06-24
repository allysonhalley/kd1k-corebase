CREATE TABLE militaries
(
    id        TEXT PRIMARY KEY,
    person_id TEXT      NOT NULL,
    register  VARCHAR(10) NOT NULL UNIQUE,
    nickname  TEXT        NOT NULL,
    hierarchy TEXT        NOT NULL,

    FOREIGN KEY (person_id) REFERENCES people
)