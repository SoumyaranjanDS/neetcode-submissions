CREATE TABLE videos (
    id INTEGER NOT NULL PRIMARY KEY,
    name TEXT ,
    created_at DATE DEFAULT NOW(),
    published BOOLEAN
);







-- Do not modify below this line --
SELECT table_name, column_name, data_type
FROM information_schema.columns
WHERE table_name = 'videos';
