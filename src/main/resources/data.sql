INSERT INTO classifiable (dtype, tconst, title_type, primary_title, original_title, is_adult, runtime_minutes, start_year, end_year, genres) values('Title','pdc1','movie','Piratas del caribe 1','Pirates of the caribbean',false, 120 , 2010, 2011, 'action,drama');
INSERT INTO classifiable (dtype, tconst, title_type, primary_title, original_title, is_adult, runtime_minutes, start_year, end_year, genres) values('Title','pdc2','movie','Piratas del caribe 2','Pirates of the caribbean 2',false, 120 , 2012, 2014, 'action,drama');

INSERT INTO principals (category, characters, job, nconst, ordering, tconst) values ('action', 'johnny depp', 'capitan jack sparrow', 'rdn', 1, 'pdc1');
INSERT INTO principals (category, characters, job, nconst, ordering, tconst) values ('action', 'johnny depp', 'pirata', 'rdn', 1, 'pdc2');

INSERT INTO crew (tconst, directors, writers) values ('pdc1', 'gore verbinski', 'ted elliot');
INSERT INTO crew (tconst, directors, writers) values ('pdc2', 'gore verbinski', 'ted elliot');

INSERT INTO user_table (critic_id, location, nickname, password, platform, type_user) values (1, 'usa', 'emma', 'asd123', 'DISNEY_PLUS', 'CRITIC');
INSERT INTO user_table (critic_id, location, nickname, password, platform, type_user) values (null, 'usa', 'john', 'asd123', 'DISNEY_PLUS', 'COMMON');
INSERT INTO user_table (critic_id, location, nickname, password, platform, type_user) values (2, 'arg', 'juana', 'asd123', 'NETFLIX', 'CRITIC');
INSERT INTO user_table (critic_id, location, nickname, password, platform, type_user) values (null, 'arg', 'raulito', 'asd123', 'NETFLIX', 'COMMON');
