-- Datos de ejemplo de la tabla Contenido
INSERT INTO content (title, release_date, img_url) VALUES
('Shingeki no Kyojin', '2013-12-09', 'public/img/portada/anime-01.jpg'),
('Death Note', '2020-03-28', 'public/img/portada/anime-02.jpg'),
('Fullmetal Alchemist', '2000-11-03', 'public/img/portada/anime-03.jpg'),
('One Piece', '2001-04-01', 'public/img/portada/anime-04.jpg'),
('Naruto', '2002-12-11', 'public/img/portada/anime-05.jpg'),
('Breaking Bad', '2012-03-27', 'public/img/portada/serie-01.jpg'),
('Game of Thrones', '2000-08-15', 'public/img/portada/serie-02.jpg'),
('La Casa de Papel', '1997-04-15', 'public/img/portada/serie-03.jpg'),
('Stranger Things', '2012-09-13', 'public/img/portada/serie-04.jpg'),
('Sherlock', '1993-12-30', 'public/img/portada/serie-05.jpg'),
('The Godfather', '1999-06-09', 'public/img/portada/pelicula-01.jpg'),
('Schindler\'s List', '1975-12-31', 'public/img/portada/pelicula-02.jpg'),
('Pulp Fiction', '2000-08-10', 'public/img/portada/pelicula-03.jpg'),
('Inception', '2015-12-26', 'public/img/portada/pelicula-04.jpg'),
('Interstellar', '1982-11-15', 'public/img/portada/pelicula-05.jpg');

-- Datos de ejemplo de la tabla Studios
INSERT INTO studios (name) VALUES
('Toei Animation'),
('Studio Ghibli'),
('Madhouse'),
('Bones'),
('Kyoto Animation'),
('Wit Studio'),
('Sunrise'),
('Trigger'),
('MAPPA'),
('Production I.G');

-- Datos de eejmplo de la tabla Directores
INSERT INTO directors (name) VALUES
('Guillermo del Toro'),
('Francis Ford Coppola'),
('Alfred Hitchcock'),
('Martin Scorsese'),
('Ridley Scott'),
('James Cameron'),
('Christopher Nolan'),
('Stanley Kubrick'),
('Quentin Tarantino'),
('Steven Spielberg');

-- Datos de ejemplo de la tabla Actores
INSERT INTO actors (name) VALUES
('Daniel Day-Lewis'),
('Jake Gyllenhaal'),
('Hugh Jackman'),
('Ewan McGregor'),
('Michael Fassbender'),
('Keanu Reeves'),
('Denzel Washington'),
('Robert Downey Jr.'),
('Leonardo DiCaprio'),
('Al Pacino'),
('Johnny Depp'),
('Benedict Cumberbatch'),
('Christian Bale'),
('Morgan Freeman'),
('Joaquin Phoenix'),
('Matt Damon'),
('Gary Oldman'),
('Brad Pitt'),
('Chris Hemsworth'),
('Tom Hanks');


-- Datos de ejemplo de la tabla Animes
INSERT INTO animes (id, studio_id) VALUES
(1, 8),
(2, 3),
(3, 4),
(4, 2),
(5, 1);

-- Datos de ejemplo de la tabla Series
INSERT INTO series (id, director_id) VALUES
(6, 3),
(7, 9),
(8, 5),
(9, 10),
(10, 6);

-- Datos de ejemplo de la tabla Peliculas
INSERT INTO movies (id, director_id) VALUES
(11, 9),
(12, 3),
(13, 2),
(14, 1),
(15, 1);

-- datos de ejemplo de la tabla Generos
INSERT INTO genres (name) VALUES
('Acción'),
('Aventura'),
('Comedia'),
('Drama'),
('Fantasía'),
('Ciencia Ficción'),
('Terror'),
('Misterio'),
('Romance'),
('Thriller'),
('Slice of Life'),
('Shonen'),
('Shojo'),
('Seinen'),
('Josei'),
('Isekai'),
('Cyberpunk'),
('Mecha'),
('Musical'),
('Deportes'),
('Histórico'),
('Psicológico'),
('Supernatural'),
('Magia'),
('Policial'),
('Artes Marciales'),
('Militar'),
('Samurái'),
('Vampiros'),
('Apocalíptico'),
('Steampunk'),
('Gore'),
('Harem'),
('Idols'),
('Parodia'),
('Espacial'),
('Ciberespionaje'),
('Ficción Distópica'),
('Zombis');

-- Datos de ejemplo de content_genres
INSERT INTO content_genres (content_id, genre_id) VALUES
(1, 1), (1, 4),
(2, 8), (2, 17),
(3, 1), (3, 2),
(4, 2), (4, 3),
(5, 1), (5, 2),
(6, 1), (6, 4),
(7, 8), (7, 17),
(8, 1), (8, 2),
(9, 2), (9, 3),
(10, 1), (10, 2),
(11, 1), (11, 4),
(12, 8), (12, 17),
(13, 1), (13, 2),
(14, 2), (14, 3),
(15, 1), (15, 2);

-- Ejemplo de datos de la tabla content_actors
INSERT INTO content_actors (content_id, actor_id) VALUES
(6, 20),
(7, 3),
(8, 14),
(9, 19),
(10, 19),
(11, 13),
(12, 1),
(13, 18),
(14, 12),
(15, 17);

-- Ejemplo de datos de la tabla usuarios (admins)
INSERT INTO users (id, username, email, password, user_type) VALUES
(1, 'javier', 'javi_admin@gmail.com', '********', 'ADMIN'),
(2, 'manuel', 'manu_admin@gmail.com', '************', 'ADMIN'),
(3, 'Schuberg', 'schuberg.4599@gmail.com', '**********', 'USER');

