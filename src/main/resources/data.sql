INSERT INTO classifiable (dtype, tconst, title_type, primary_title, original_title, is_adult, runtime_minutes, start_year, end_year, genres) values('Title','pdc1','movie','Piratas del caribe 1','Pirates of the caribbean',false, 120 , 2010, 2011, 'action,drama');
INSERT INTO classifiable (dtype, tconst, title_type, primary_title, original_title, is_adult, runtime_minutes, start_year, end_year, genres) values('Title','pdc2','movie','Piratas del caribe 2','Pirates of the caribbean 2',false, 120 , 2012, 2014, 'action,drama');

INSERT INTO principals (category, characters, job, nconst, ordering, tconst) values ('action', 'johnny depp', 'capitan jack sparrow', 'rdn', 1, 'pdc1');
INSERT INTO principals (category, characters, job, nconst, ordering, tconst) values ('action', 'johnny depp', 'pirata', 'rdn', 1, 'pdc2');

INSERT INTO crew (tconst, directors, writers) values ('pdc1', 'gore verbinski', 'ted elliot');
INSERT INTO crew (tconst, directors, writers) values ('pdc2', 'gore verbinski', 'ted elliot');
