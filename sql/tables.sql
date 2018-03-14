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

