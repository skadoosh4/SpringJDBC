package com.sidharth.school.service;

import com.sidharth.school.model.Student;
import com.sidharth.school.model.Teacher;
import com.sidharth.school.repository.StudentRepository;
import com.sidharth.school.repository.StudentTeacherRepository;
import com.sidharth.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepo;
    private final StudentTeacherRepository studentTeacherRepo;
    private final TeacherRepository teacherRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo, StudentTeacherRepository studentTeacherRepo, TeacherRepository teacherRepo) {
        this.studentRepo = studentRepo;
        this.studentTeacherRepo = studentTeacherRepo;
        this.teacherRepo = teacherRepo;
    }

    @Transactional
    @Override
    public void createStudentAndAssignTeacher(Student student, Long teacherId) {
        studentRepo.save(student);

        studentTeacherRepo.assignStudentToTeacher(student.getId(), teacherId);
    }

    @Override
    public Iterable<Student> getAllStudents(Integer age) {
        return studentRepo.findByAge(age);
    }

    @Override
    public Iterable<Teacher> getTeachersByStudentId(Long id) {
        return teacherRepo.findByStudentId(id);
    }
}
