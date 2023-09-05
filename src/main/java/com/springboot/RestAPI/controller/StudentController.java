package com.springboot.RestAPI.controller;
import com.springboot.RestAPI.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,"Ravi","Chandola");
        return student;
    }
@GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ram","Srivastav"));
        students.add(new Student(2,"Girish","Srivastav"));
        students.add(new Student(3,"Nimish","Srivastav"));
        students.add(new Student(4,"Dakshita","Srivastav"));
        return students;
    }
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVar(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String firstName,
                                  @PathVariable("last-name") String lastName
                                  ){
        return new Student(studentId,firstName,lastName);
    }

    //Spring Boot Rest API with Request Param
    //localhost:8081/students/query?id=2&firstName=Ravi&lastName=Chandola
    @GetMapping("students/query")
    public Student studentRequestParam(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    //Spring Boot Rest API that handles HTTP Post Request
    //@PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return student;
    }

}
