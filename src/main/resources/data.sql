#INSERT INTO title (tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear,runtimeMinutes, genres) values('pdc1', 'short', 'Piratas del caribe','Pirates of the caribbean', 0, 2004, null, 120, 'Action,Romance');
#INSERT INTO review (review_id, title_tconst, rating, resume, language, date, extended_text, user_id) values(1,'pdc1','4','buenisima peli','es','04/05/2021','pelicula muy buena',1)

INSERT INTO review (dtype, tittle_tconst, rating, resume, language, date, extended_text, user_id, spoiler_alert) values('asd','pdc1','4','buenisima peli','es','04/05/2021','pelicula muy buena',1,false)

INSERT INTO review (dtype, tittle_tconst, rating, resume, language, date, extended_text, user_id, critic_id) values('PremiumReview','pdc2','4','buenisima peli','es','04/05/2021','pelicula muy buena',1,2)
