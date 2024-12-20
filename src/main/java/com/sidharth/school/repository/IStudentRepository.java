package com.sidharth.school.repository;


import com.sidharth.school.model.Student;

public interface IStudentRepository {
    Iterable<Student> findByAge(Integer age);
    int save(Student student);
    int update(Student student);
    int delete(Long id);
}
