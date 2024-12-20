package com.sidharth.school.repository;


import com.sidharth.school.model.Teacher;

public interface ITeacherRepository {
    Iterable<Teacher> findByStudentId(Long id);
}
