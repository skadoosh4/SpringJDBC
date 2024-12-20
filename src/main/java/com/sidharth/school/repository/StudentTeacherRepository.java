package com.sidharth.school.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentTeacherRepository implements IStudentTeacherRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentTeacherRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int assignStudentToTeacher(Long studentId, Long teacherId) {
        String sql = "INSERT INTO Student_Teacher(student_id,teacher_id) VALUES(? , ?)";
        return jdbcTemplate.update(sql , studentId , teacherId);
    }
}
