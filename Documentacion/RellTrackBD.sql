CREATE DATABASE IF NOT EXISTS RellTrack;
USE RellTrack;

-- Tabla de Directores
CREATE TABLE directors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);

-- Tabla de Estudios de Animación
CREATE TABLE studios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);

-- Tabla de Actores
CREATE TABLE actors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);

-- Tabla de Géneros
CREATE TABLE genres (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);

-- Tabla de Usuarios
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    email TEXT NOT NULL,
    user_type TEXT NOT NULL
);

-- Tabla de Contenido
CREATE TABLE content (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title TEXT NOT NULL,
    release_date DATE NOT NULL,
    image_url TEXT NOT NULL
);

-- Tabla de Series
CREATE TABLE series (
    id INT PRIMARY KEY AUTO_INCREMENT,
    director_id INT,
    FOREIGN KEY (id) REFERENCES content(id) ON DELETE CASCADE,
    FOREIGN KEY (director_id) REFERENCES directors(id) ON DELETE SET NULL
);

-- Tabla de Películas
CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    director_id INT,
    FOREIGN KEY (id) REFERENCES content(id) ON DELETE CASCADE,
    FOREIGN KEY (director_id) REFERENCES directors(id) ON DELETE SET NULL
);

-- Tabla de Animes
CREATE TABLE animes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    studio_id INT,
    FOREIGN KEY (id) REFERENCES content(id) ON DELETE CASCADE,
    FOREIGN KEY (studio_id) REFERENCES studios(id) ON DELETE SET NULL
);

-- Tabla de Temporadas
CREATE TABLE seasons (
    id INT PRIMARY KEY AUTO_INCREMENT,
    content_id INT NOT NULL,
    season_number INT NOT NULL,
    FOREIGN KEY (content_id) REFERENCES content(id) ON DELETE CASCADE
);

-- Relación Contenido-Géneros
CREATE TABLE content_genres (
    content_id INT NOT NULL,
    genre_id INT NOT NULL,
    PRIMARY KEY (content_id, genre_id),
    FOREIGN KEY (content_id) REFERENCES content(id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);

-- Relación Contenido-Actores
CREATE TABLE content_actors (
    content_id INT NOT NULL,
    actor_id INT NOT NULL,
    PRIMARY KEY (content_id, actor_id),
    FOREIGN KEY (content_id) REFERENCES content(id) ON DELETE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES actors(id) ON DELETE CASCADE
);

-- Catálogo de usuarios con calificaciones
CREATE TABLE user_catalog (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    content_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 10),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (content_id) REFERENCES content(id) ON DELETE CASCADE
);
