package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb;

    HashMap<String,Teacher> teacherDb;

    HashMap<String , List<String>> teacherStudentPair;

    List<String > allStudents;

    public StudentRepository() {
        studentDb=new HashMap<>();
        teacherDb=new HashMap<>();
        teacherStudentPair = new HashMap<>();
        allStudents=new ArrayList<>();
    }

    public void addStudent(Student student){
        String key=student.getName();
        studentDb.put(key,student);
        allStudents.add(student.getName());
    }

    public Student getStudentByName(String studentName){
        if(studentDb.containsKey(studentName)){
            return studentDb.get(studentName);
        }else{
            return  null;
        }
    }

    public void addTeacher(Teacher teacher){
        String key=teacher.getName();
        teacherDb.put(key,teacher);
    }

    public Teacher getTeacherByName(String teacherName){
        return  teacherDb.get(teacherName);
    }

    public void addStudentTeacherPair(String student , String teahcer){

        if(!teacherStudentPair.containsKey(teahcer)){
            teacherStudentPair.put(teahcer,new ArrayList<>());
        }
        teacherStudentPair.get(teahcer).add(student);
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        for(String teacher:teacherStudentPair.keySet()){
            if(teacher.equals(teacher)){
                return teacherStudentPair.get(teacher);
            }
        }
        return null;
    }

    public List<String > getAllStudents(){
        return allStudents;
    }

    public void deleteTeacherByName(String teacherName){


        for(String teacher:teacherStudentPair.keySet()){
            if(teacher.equals(teacherName)){
                for(String student:teacherStudentPair.get(teacher)){
                    teacherDb.remove(student);
                    allStudents.remove(student);
                }
            }
        }
        teacherDb.remove(teacherName);
        teacherStudentPair.remove(teacherName);
    }

    public void deleteAllTeachers(){
        for(String teacher:teacherStudentPair.keySet()){
            for(String student:teacherStudentPair.get(teacher)){
                studentDb.remove(student);
                allStudents.remove(student);
            }
        }

        teacherDb.clear();
        teacherStudentPair.clear();
    }


}
