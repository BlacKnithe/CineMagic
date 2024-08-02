CREATE TABLE Usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE Películas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    título VARCHAR(200) NOT NULL,
    descripción TEXT,
    duración INT,
    clasificación VARCHAR(50)
);

CREATE TABLE Funciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pelicula_id BIGINT,
    fecha_hora DATETIME NOT NULL,
    sala VARCHAR(50) NOT NULL,
    FOREIGN KEY (pelicula_id) REFERENCES Películas(id)
);

CREATE TABLE Boletos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    funcion_id BIGINT,
    asiento VARCHAR(10),
    precio DECIMAL(10, 2),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    FOREIGN KEY (funcion_id) REFERENCES Funciones(id)
);

CREATE TABLE Reseñas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pelicula_id BIGINT,
    usuario_id BIGINT,
    calificación INT CHECK (calificación >= 1 AND calificación <= 5),
    comentario TEXT,
    FOREIGN KEY (pelicula_id) REFERENCES Películas(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);
