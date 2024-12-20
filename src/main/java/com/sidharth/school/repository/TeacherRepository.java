package com.sidharth.school.repository;

import com.sidharth.school.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TeacherRepository implements ITeacherRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Teacher> findByStudentId(Long id) {
        String sql = "SELECT t.* FROM Teacher t JOIN Student_Teacher st ON t.id = st.teacher_id WHERE st.student_id = ?";
        return jdbcTemplate.query(sql , this::mapRowToTeacher , id);
    }

    private Teacher mapRowToTeacher(ResultSet row , int rowNum) throws SQLException {
        return new Teacher(
                row.getLong("id"),
                row.getString("name"),
                row.getString("email"),
                row.getString("course")
        );
    }
}
