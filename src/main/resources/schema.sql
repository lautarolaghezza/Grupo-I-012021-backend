/*CREATE TABLE public."title"
(
    tconst varchar(100) NOT NULL,
    titleType varchar(100),
    primaryTitle varchar(100),
    originalTitle varchar(100),
    isAdult integer,
    startYear integer,
    endYear integer,
    runtimeMinutes integer,
    genres varchar(100),
    PRIMARY KEY (tconst)
);

CREATE TABLE public."review"
(
    review_id serial,
    title_tconst varchar(100),
    rating varchar(100),
    resume varchar(240),
    language varchar(100),
    date date,
    extended_text varchar(240),
    user_id integer,
    PRIMARY KEY (review_id)
)

*/

