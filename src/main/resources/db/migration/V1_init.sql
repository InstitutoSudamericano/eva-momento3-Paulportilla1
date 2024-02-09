CREATE TABLE IF NOT EXISTS film(
    id SERIAL,
    itle VARCHAR (100),
    director VARCHAR (100),
    duration INT,
    investment INT,
    release_date DATE,
    gender VARCHAR (50),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS scene(
    id SERIAL,
    description VARCHAR (100),
    budget VARCHAR (100),
    minutes INT,
    location VARCHAR(100),
    start_time TIME,
    cost_of_the_suit DECIMAL,
    makeup_cost DECIMAL,
    film_id INT NOT NULL,
    FOREIGN KEY (film_id) REFERENCES film(id)
    );


CREATE TABLE IF NOT EXISTS character(
    id SERIAL,
    actor VARCHAR(100),
    description VARCHAR (100),
    cost DECIMAL (10,2),
    stock DECIMAL (10,2),
    scene_id INT NOT NULL,
    FOREIGN KEY (scene_id) REFERENCES scene(id)
    );