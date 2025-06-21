CREATE TABLE students (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE skills (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        student_id BIGINT,
                        name VARCHAR(255),
                        FOREIGN KEY (student_id) REFERENCES students(id)
);
