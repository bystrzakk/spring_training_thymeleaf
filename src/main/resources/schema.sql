DROP TABLE IF EXISTS COURSE;

CREATE TABLE COURSE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  course_name VARCHAR(250) NOT NULL,
  categories VARCHAR(250) NOT NULL
);
