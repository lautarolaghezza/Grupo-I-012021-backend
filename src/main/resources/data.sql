INSERT INTO classifiable (dtype, tconst, title_type, primary_title, original_title, is_adult, runtime_minutes, start_year, end_year, genres) values('Title','pdc1','movie','Piratas del caribe 1','Pirates of the caribbean',false, 120 , 2010, 2011, 'action,drama');

INSERT INTO principals (category, characters, job, nconst, ordering, tconst) values ('action', 'robert de niro', 'empleado', 'rdn', 1, 'pdc1');

INSERT INTO crew (tconst, directors, writers) values ('pdc1', 'alpacino', 'alpacino escritor');
