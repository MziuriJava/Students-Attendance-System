CREATE TABLE staff (
  id SERIAL PRIMARY KEY NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  main_phone_number VARCHAR(50),
  additional_phone_number VARCHAR(50),
  password VARCHAR(50) NOT NULL,
  staff_status VARCHAR(50) NOT NULL
);
CREATE TABLE course(
  id SERIAL PRIMARY KEY NOT NULL,
  course_name VARCHAR(30),
  course_status VARCHAR(30),
  course_length INTEGER,
  course_lesson_time INTEGER,
  lessons_per_week INT,
  description VARCHAR,
  leader_staff INT REFERENCES staff(id),
  price INTEGER
);
CREATE TABLE group(
  id SERIAL PRIMARY KEY NOT NULL,
  groupName VARCHAR(30),
  startDate DATE,
  fk_course INT REFERENCES course(id),
  fk_staff INT REFERENCES staff(id)
);

