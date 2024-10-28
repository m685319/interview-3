-- Создание таблицы User_table
CREATE TABLE user_table
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

-- Создание таблицы friendship
CREATE TABLE friendship
(
    id    SERIAL PRIMARY KEY,
    user_1 BIGINT REFERENCES user_table (id) ON DELETE CASCADE,
    user_2 BIGINT REFERENCES user_table (id) ON DELETE CASCADE,
    UNIQUE (user_1, user_2)
);
