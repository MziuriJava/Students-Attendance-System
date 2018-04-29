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
  lessons_per_week INTEGER,
  description VARCHAR,
  leader_staff INT REFERENCES staff(id),
  price INTEGER
);
ALTER TABLE course ADD COLUMN syllabus bytea;
ALTER TABLE course DROP COLUMN course_lesson_time;
ALTER TABLE course ADD COLUMN course_lesson_time REAL;

CREATE TABLE student(
  id SERIAL PRIMARY KEY NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50),
  phone_number VARCHAR(50),
  parent_name VARCHAR(50),
  parent_number VARCHAR(50),
  personal_id VARCHAR(50) NOT NULL,
  birth_date DATE NOT NULL,
  school VARCHAR(50) NOT NULL
);

CREATE TABLE class_group(
  id SERIAL PRIMARY KEY NOT NULL,
  groupName VARCHAR(30),
  startDate DATE,
  course_id INT REFERENCES course(id),
  staff_id INT REFERENCES staff(id)
);

CREATE TABLE journal(
 student_id INT REFERENCES student(id),
 group_id INT REFERENCES class_group(id),
 date DATE,
 attendance BOOLEAN,
 lesson_mark INT,
 homework_mark INT,
 test_mark INT
)
