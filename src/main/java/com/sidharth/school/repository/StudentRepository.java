package com.sidharth.school.repository;

import com.sidharth.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentRepository implements IStudentRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Student> findByAge(Integer age) {
        String sql = "SELECT * FROM Student";
        if(age!=null && age>0){
            sql += " WHERE age >= ?";
            return jdbcTemplate.query(sql , this::mapRowToStudent , age);
        }
        return jdbcTemplate.query(sql , this::mapRowToStudent);
    }

    @Override
    public int save(Student student) {
        String sql = "INSERT INTO Student (id , age , name , major) values (? , ? , ? , ?)";
        return jdbcTemplate.update(sql , student.getId() , student.getAge() , student.getName() , student.getMajor());
    }

    @Override
    public int update(Student student) {
        String sql = "UPDATE Student SET age = ? , name = ? , major = ? WHERE id = ?";
        return jdbcTemplate.update(sql , student.getAge() , student.getName() , student.getMajor() , student.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = "DELETE FROM Student WHERE id = ?";
        return jdbcTemplate.update(sql , id);
    }

    private Student mapRowToStudent(ResultSet row , int rowNum) throws SQLException {
        return new Student(
                row.getLong("id"),
                row.getInt("age"),
                row.getString("name"),
                row.getString("major")
        );
    }
}
