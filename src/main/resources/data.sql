delete FROM Teacher;
delete FROM Student;
delete FROM Student_Teacher;
INSERT INTO Student (id, age, name, major)
VALUES
    (1, 20, 'John Doe', 'Computer Science'),
    (2, 22, 'Jane Smith', 'Mathematics'),
    (3, 21, 'Emily Johnson', 'Physics'),
    (4, 23, 'Michael Brown', 'Biology'),
    (5, 19, 'Sarah Davis', 'Engineering');

INSERT INTO Teacher (id, name, email, course)
VALUES
    (1, 'Dr. Alice Johnson', 'alice.johnson@example.com', 'Computer Science 101'),
    (2, 'Prof. Robert Brown', 'robert.brown@example.com', 'Mathematics 201'),
    (3, 'Dr. Sarah Lee', 'sarah.lee@example.com', 'Physics 301'),
    (4, 'Prof. Michael White', 'michael.white@example.com', 'Biology 101'),
    (5, 'Dr. Emily Black', 'emily.black@example.com', 'Engineering 101');

INSERT INTO Student_Teacher (id, student_id, teacher_id)
VALUES
    (1, 1, 1),  -- John Doe (Student 1) is taught by Dr. Alice Johnson (Teacher 1)
    (2, 2, 2),  -- Jane Smith (Student 2) is taught by Prof. Robert Brown (Teacher 2)
    (3, 3, 3),  -- Emily Johnson (Student 3) is taught by Dr. Sarah Lee (Teacher 3)
    (4, 4, 4),  -- Michael Brown (Student 4) is taught by Prof. Michael White (Teacher 4)
    (5, 5, 5);  -- Sarah Davis (Student 5) is taught by Dr. Emily Black (Teacher 5)

