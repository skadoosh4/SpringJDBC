package com.sidharth.school.service;

import com.sidharth.school.model.Student;
import com.sidharth.school.model.Teacher;

public interface IStudentService {
    void createStudentAndAssignTeacher(Student student , Long id);
    Iterable<Student> getAllStudents(Integer age);
    Iterable<Teacher> getTeachersByStudentId(Long id);
}
