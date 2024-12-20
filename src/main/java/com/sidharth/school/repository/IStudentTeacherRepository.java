package com.sidharth.school.repository;

public interface IStudentTeacherRepository {
    int assignStudentToTeacher(Long studentId , Long teacherId);
}
