package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public Student getStudentByName(String studentName){
        Student student=studentRepository.getStudentByName(studentName);
        return student;
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public Teacher getTeacherByName(String teacherName){
        return  studentRepository.getTeacherByName(teacherName);
    }

    public void addStudentTeacherPair(String student,String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        return studentRepository.getStudentsByTeacherName(teacherName);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
