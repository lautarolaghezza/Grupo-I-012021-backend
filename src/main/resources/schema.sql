CREATE TABLE title
(
    tconst         varchar(100) NOT NULL,
    titleType      varchar(100) DEFAULT NULL,
    primaryTitle   varchar(100) DEFAULT NULL,
    originalTitle  varchar(100) DEFAULT NULL,
    isAdult        INTEGER      DEFAULT 0,
    startYear      INTEGER      DEFAULT NULL,
    endYear        INTEGER      DEFAULT NULL,
    runtimeMinutes INTEGER      DEFAULT NULL,
    genres         varchar(100) DEFAULT NULL,
    PRIMARY KEY (tconst)
)
